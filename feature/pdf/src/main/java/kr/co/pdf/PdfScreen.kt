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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import kr.co.pdf.model.UiIntent
import kr.co.pdf.model.UiState
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.SimpleTextField
import kr.co.ui.widget.TextFieldInputType
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable
import org.koin.androidx.compose.koinViewModel
import java.io.File

@Composable
internal fun PdfRoute(
    path: String,
    viewModel: PdfViewModel = koinViewModel(),
    popBackStack: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val uri = remember { Uri.fromFile(File(path)) }

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    LaunchedEffect(path) {
        context.contentResolver.openFileDescriptor(
            uri,
            "r"
        )?.let { viewModel.handleIntent(UiIntent.Init(PdfRenderer(it))) }
    }



    val listState = rememberLazyListState()

        PdfScreen(
            uiState = uiState,
            listState = listState,
            handleIntent = viewModel::handleIntent,
            onPageIndexChange = { page ->
                scope.launch {
                    listState.scrollToItem(page - 1)
                }
            },
        )

}

@Composable
private fun PdfScreen(
    uiState: UiState = UiState(),
    listState: LazyListState = rememberLazyListState(),
    handleIntent: (UiIntent) -> Unit = {},
    onPageIndexChange: (Int) -> Unit = {},
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
                            handleIntent(UiIntent.ShowTopBar)
                        },
                        onPress = {
                            handleIntent(UiIntent.ShowTopBar)
                        }
                    )
                },
            state = listState,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(uiState.totalPage) { page ->
                LaunchedEffect(page) {
                    handleIntent(UiIntent.RenderPage(page))
                }

                PdfImage(
                    bitmap = uiState.bitmaps[page],
                )
            }
        }

        AnimatedVisibility(
            visible = uiState.topBarState.topBarVisible,
            enter = slideIn {
                IntOffset(0, -it.height)
            },
            exit = slideOut {
                IntOffset(0, -it.height)
            }
        ) {
            PdfTopBar(
                currentPage = listState.firstVisibleItemIndex + 1,
                totalPage = uiState.totalPage,
                onPageIndexChange = {
                    handleIntent(UiIntent.ChangePage(it))
                    onPageIndexChange(it)
                }
            )
        }
    }
}

@Composable
private fun PdfImage(
    bitmap: Bitmap?,
) {
    bitmap?.let {
        Image(
            bitmap = it.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(it.width.toFloat() / it.height.toFloat())
        )
    } ?: Box(
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PdfTopBar(
    currentPage: Int = 1,
    totalPage: Int = 1,
    onPageIndexChange: (Int) -> Unit = {}
) {
    val (page, onPageChange) = remember { mutableStateOf(currentPage.toString()) }

    LaunchedEffect(currentPage) {
        onPageChange(currentPage.toString())
    }

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
                    modifier = Modifier.width(56.dp),
                    value = page,
                    onValueChange = {
                        onPageChange(it)

                        if (it.isNotEmpty() && it.isDigitsOnly()) {
                            onPageIndexChange(it.toInt())
                        }
                    },
                    inputType = TextFieldInputType.NUMBER
                )

                Spacer(Modifier.width(4.dp))

                Text(
                    text = "/$totalPage",
                    style = Theme.typography.body1sb,
                    color = Theme.colors.text
                )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewTopBar() {
    SeeDocsTheme {
        PdfTopBar()
    }
}