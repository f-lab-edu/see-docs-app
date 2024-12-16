package kr.co.pdf

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme

@Composable
internal fun PdfRoute(
    popBackStack: () -> Unit = {}
) {
    PdfScreen(
        popBackStack = popBackStack
    )
}

@Composable
private fun PdfScreen(
    popBackStack: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.bg)
    ) {
        //TODO PDF 화면 렌더링 기능 구현 후 UI 표시
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        PdfScreen()
    }
}