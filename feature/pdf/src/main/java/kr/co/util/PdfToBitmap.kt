package kr.co.util

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class PdfToBitmap(
    private val renderer: PdfRenderer,
) {

    private val _bitmap = MutableStateFlow<Map<Int, Bitmap>>(emptyMap())
    val bitmap = _bitmap.asStateFlow()

    private val renderingPages = mutableSetOf<Int>()

    private val mutex = Mutex()

    suspend fun renderPage(pageIndex: Int) {
        mutex.withLock {
            if (renderingPages.contains(pageIndex)) return
            renderingPages.add(pageIndex)
        }

        val page = renderer.openPage(pageIndex)

        val bitmap =
            Bitmap.createBitmap(
                page.width * SCALE_UP,
                page.height * SCALE_UP,
                Bitmap.Config.ARGB_8888
            ).also {
                page.render(it, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                page.close()
            }


        _bitmap.update { it + (pageIndex to bitmap) }
    }

    internal fun close() {
        renderer.close()
    }

    private companion object {
        private const val SCALE_UP = 3
    }
}

@Composable
internal fun rememberPdfState(
    renderer: PdfRenderer,
): PdfToBitmap {
    val pdfState = remember { PdfToBitmap(renderer) }
    DisposableEffect(Unit) {
        onDispose {
            pdfState.close()
        }
    }
    return pdfState
}