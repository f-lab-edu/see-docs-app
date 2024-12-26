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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.seedocs.feature.bookmark.R
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.FileBox

@Composable
internal fun BookmarkRoute(
    padding: PaddingValues
) {
    BookmarkScreen(
        padding = padding
    )
}

@Composable
private fun BookmarkScreen(
    padding: PaddingValues,
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
                    text = stringResource(R.string.feature_bookmark_bookmark),
                    style = Theme.typography.body1sb,
                    color = Theme.colors.text
                )
            }

            //TODO 로컬에 저장된 북마크 데이터를 불러와 파일목록을 보여줄 예정
            items(listOf("Effective Kotlin", "Android Developer")) { file ->
                FileBox(
                    name = file
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