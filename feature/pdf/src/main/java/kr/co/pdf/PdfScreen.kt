package kr.co.pdf

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import java.io.File

@Composable
internal fun PdfRoute(
    path: String,
    popBackStack: () -> Unit = {},
) {
    val uri = Uri.fromFile(File(path))

    val context = LocalContext.current

    val renderer = remember(uri) {
        context.contentResolver.openFileDescriptor(
            uri,
            "r"
        )?.let { PdfRenderer(it) }
    }

    renderer?.let {
        PdfScreen(
            renderer = it,
            popBackStack = popBackStack
        )
    }
}

@Composable
private fun PdfScreen(
    renderer: PdfRenderer,
    popBackStack: () -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.bg)
    ) {
        items(renderer.pageCount) { page ->
            PdfImage(
                renderer = renderer,
                pageIndex = page
            )
        }
    }
}

@Composable
private fun PdfImage(
    renderer: PdfRenderer,
    pageIndex: Int,
) {
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }

    LaunchedEffect(Unit) {
        val page = renderer.openPage(pageIndex)
        Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888).also {
            page.render(it, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            bitmap = it
            page.close()
        }
    }

    bitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
//        PdfScreen()
    }
}