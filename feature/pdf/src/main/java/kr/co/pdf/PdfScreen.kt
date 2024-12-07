package kr.co.pdf

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.SimpleTextField
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable
import java.io.File

@Composable
internal fun PdfRoute(
    path: String,
    popBackStack: () -> Unit = {},
) {
    val uri = Uri.fromFile(File(path))

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val renderer = remember(uri) {
        context.contentResolver.openFileDescriptor(
            uri,
            "r"
        )?.let { PdfRenderer(it) }
    }

    var isTopBarVisible by remember { mutableStateOf(false) }
    var tobBarJob by remember { mutableStateOf<Job?>(null) }

    renderer?.let {
        PdfScreen(
            renderer = it,
            isTopBarVisible = isTopBarVisible,
            onTopBarVisibleChange = {
                tobBarJob?.cancel()

                tobBarJob = scope.launch {
                    isTopBarVisible = true
                    delay(3000)
                    isTopBarVisible = false
                }
            },
            popBackStack = popBackStack
        )
    }
}

@Composable
private fun PdfScreen(
    renderer: PdfRenderer,
    isTopBarVisible: Boolean = false,
    onTopBarVisibleChange: () -> Unit,
    popBackStack: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.stroke)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .zoomable(rememberZoomState())
                .pointerInput(null) {
                    detectTapGestures(
                        onTap = {
                            onTopBarVisibleChange()
                        },
                        onPress = {
                            onTopBarVisibleChange()
                        }
                    )
                },
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(renderer.pageCount) { page ->
                PdfImage(
                    renderer = renderer,
                    pageIndex = page
                )
            }
        }

        AnimatedVisibility(
            visible = isTopBarVisible,
            enter = slideIn {
                IntOffset(0, -it.height)
            },
            exit = slideOut {
                IntOffset(0, -it.height)
            }
        ) {
            PdfTopBar(

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
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isLoading = true
        val page = renderer.openPage(pageIndex)
        Bitmap.createBitmap(page.width * 3, page.height * 3, Bitmap.Config.ARGB_8888).also {
            page.render(it, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            bitmap = it
            page.close()
            isLoading = false
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = ColorPainter(Theme.colors.grayText),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            CircularProgressIndicator(
                color = Theme.colors.highlight
            )
        }
    } else {
        bitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(it.width.toFloat() / it.height.toFloat())
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PdfTopBar(
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Theme.colors.bg)
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SimpleTextField(
                    modifier = Modifier.width(40.dp),
                    value = "1",
                    onValueChange = {},
                )

                Spacer(Modifier.width(4.dp))

                Text(
                    text = "/34",
                    style = Theme.typography.body1sb,
                    color = Theme.colors.text
                )
            }
        }
    )
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
//        PdfScreen()
    }
}

@Preview
@Composable
private fun PreviewTopBar() {
    SeeDocsTheme {
        PdfTopBar()
    }
}