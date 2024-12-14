package kr.co.bookmark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.model.BookmarkUiState
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.FileBox
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDateTime

@Composable
internal fun BookmarkRoute(
    padding: PaddingValues,
    viewModel: BookmarkViewModel = koinViewModel(),
    navigateToPdf: (String) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    
    BookmarkScreen(
        padding = padding,
        state = state,
        onFileClick = navigateToPdf
    )
}

@Composable
private fun BookmarkScreen(
    padding: PaddingValues,
    state: BookmarkUiState = BookmarkUiState.EMPTY,
    onFileClick: (String) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.bg)
            .padding(padding)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Spacer(Modifier.height(32.dp))

                Text(
                    text = "북마크",
                    style = Theme.typography.body1sb,
                    color = Theme.colors.text
                )
            }

            items(state.files) { file ->
                FileBox(
                    name = file.name,
                    dateTime = file.createdAt,
                    onFileClick = { onFileClick(file.path) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        BookmarkScreen(
            padding = PaddingValues()
        )
    }
}