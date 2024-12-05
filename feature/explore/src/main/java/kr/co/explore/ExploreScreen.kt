package kr.co.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.FileBox
import kr.co.widget.FolderBox
import java.io.File

@Composable
internal fun ExploreRoute(
    path: String,
    padding: PaddingValues,
    navigateToFolder: (String) -> Unit = {},
    navigateToPdf: (String) -> Unit = {},
) {
    val files = readPDFOrDirectory(path)

    ExploreScreen(
        path = path.replace("/storage/emulated/0", "내장 저장 공간"),
        files = files,
        padding = padding,
        onFolderClick = { folderPath -> navigateToFolder(folderPath) },
        onFileClick = navigateToPdf
    )
}

@Composable
private fun ExploreScreen(
    path: String,
    files: List<Item> = emptyList(),
    padding: PaddingValues,
    onFolderClick: (String) -> Unit = {},
    onFileClick: (String) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(color = Theme.colors.bg),
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
                            append(">${path.split("/").dropLast(1).joinToString(separator = "/")}")
                            append("/")
                            withStyle(
                                Theme.typography.caption1r.copy(color = Theme.colors.highlight)
                                    .toSpanStyle()
                            ) {
                                append(path.split("/").last())
                            }
                        },
                        style = Theme.typography.caption1r,
                        color = Theme.colors.grayText,
                    )
                }
            }

            items(files.filter { it.isDirectory }) { folder ->
                FolderBox(
                    name = folder.name,
                    onClick = { onFolderClick(folder.path) }
                )
            }

            items(
                items = files.filter { !it.isDirectory },
                span = { GridItemSpan(maxLineSpan) }
            ) { file ->
                FileBox(
                    name = file.name,
                    onFileClick = { onFileClick(file.path) }
                )
            }
        }
    }
}

private fun readPDFOrDirectory(
    path: String,
): List<Item> =
    File(path).listFiles()?.filter { !it.isHidden && (it.isDirectory || it.extension == "pdf") }?.map {
        Item(
            name = it.name,
            path = it.path,
            type = it.extension,
            isDirectory = it.isDirectory
        )
    }?: emptyList()

private data class Item(
    val name: String,
    val path: String,
    val type: String,
    val isDirectory: Boolean,
)

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        ExploreScreen(
            path = "/storage/emulated/0/Download",
            padding = PaddingValues(),
        )
    }
}