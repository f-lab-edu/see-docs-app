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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.model.FileInfo
import kr.co.seedocs.feature.explore.R
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.widget.FileBox
import kr.co.util.DEFAULT_STORAGE
import kr.co.util.readPDFOrDirectory
import kr.co.widget.FolderBox

@Composable
internal fun ExploreRoute(
    path: String,
    padding: PaddingValues,
    navigateToFolder: (String) -> Unit = {},
    navigateToPdf: (String) -> Unit = {},
) {
    var files by remember { mutableStateOf<List<FileInfo>>(emptyList()) }

    LaunchedEffect(Unit) {
        files = readPDFOrDirectory(path)
    }

    ExploreScreen(
        path = path.replace(DEFAULT_STORAGE,
            stringResource(R.string.feature_explore_local_storage)),
        files = files,
        padding = padding,
        onFolderClick = { folderPath -> navigateToFolder(folderPath) },
        onFileClick = navigateToPdf
    )
}

@Composable
private fun ExploreScreen(
    path: String,
    files: List<FileInfo> = emptyList(),
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
                        text = stringResource(R.string.feature_explore_file_explore),
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

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        ExploreScreen(
            path = DEFAULT_STORAGE,
            padding = PaddingValues(),
        )
    }
}