package kr.co.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.widget.FileBox
import kr.co.widget.FolderBox

@Composable
internal fun ExploreRoute(
    viewModel: ExploreViewModel = hiltViewModel(),
    padding: PaddingValues,
) {

    ExploreScreen(
        padding = padding,
    )
}

@Composable
private fun ExploreScreen(
    padding: PaddingValues,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(color = Theme.colors.bg)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(
                    top = 32.dp
                )
                .padding(
                    horizontal = 16.dp
                ),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "파일 탐색",
                        style = Theme.typography.body1sb,
                        color = Theme.colors.text
                    )
                    Text(
                        text = buildAnnotatedString {
                            append("규상의 S24 >")
                            withStyle(
                                Theme.typography.caption1r.copy(color = Theme.colors.highlight)
                                    .toSpanStyle()
                            ) {
                                append("Download")
                            }
                        },
                        style = Theme.typography.caption1r,
                        color = Theme.colors.grayText,
                    )
                }
            }

            items(listOf("Download", "Documents", "DCIM")) { folder ->
                FolderBox(
                    name = folder
                )
            }

            items(
                items = listOf("Effective Kotlin", "Android Developer"),
                span = { GridItemSpan(maxLineSpan) }
            ) { file ->
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
        ExploreScreen(
            padding = PaddingValues(),
        )
    }
}