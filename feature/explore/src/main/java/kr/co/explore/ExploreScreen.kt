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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.model.ExploreSideEffect
import kr.co.model.ExploreUiIntent
import kr.co.model.ExploreUiState
import kr.co.model.FileInfo
import kr.co.seedocs.feature.explore.R
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.util.LaunchIntentHandler
import kr.co.ui.util.LaunchSideEffect
import kr.co.ui.widget.FileBox
import kr.co.util.DEFAULT_STORAGE
import kr.co.widget.FolderBox
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun ExploreRoute(
    path: String,
    padding: PaddingValues,
    navigateToFolder: (String) -> Unit = {},
    navigateToPdf: (String) -> Unit = {},
    viewModel: ExploreViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchIntentHandler(ExploreUiIntent.Init(path), viewModel)

    LaunchSideEffect(viewModel) {
        when (it) {
            is ExploreSideEffect.NavigateToPdf -> navigateToPdf(it.path)
            is ExploreSideEffect.NavigateToFolder -> navigateToFolder(it.path)
        }
    }

    ExploreScreen(
        state = state,
        padding = padding,
        handleIntent = viewModel::handleIntent,
    )
}

@Composable
private fun ExploreScreen(
    state: ExploreUiState = ExploreUiState.INIT,
    padding: PaddingValues,
    handleIntent: (ExploreUiIntent) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(color = Theme.colors.bg),
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
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
                        text = buildPath(state.path),
                        style = Theme.typography.caption1r,
                        color = Theme.colors.grayText,
                    )
                }
            }

            items(state.folders) { folder ->
                FolderBox(
                    name = folder.name,
                    onClick = { handleIntent(ExploreUiIntent.ClickFolder(folder)) }
                )
            }

            items(
                items = state.files,
                span = { GridItemSpan(maxLineSpan) }
            ) { file ->
                FileBox(
                    name = file.name,
                    dateTime = file.createdAt,
                    onFileClick = { handleIntent(ExploreUiIntent.ClickFile(file)) }
                )
            }
        }
    }
}

@Composable
private fun buildPath(path: String): AnnotatedString =
    buildAnnotatedString {
        val relativePath = path.replace(
            DEFAULT_STORAGE,
            stringResource(R.string.feature_explore_local_storage)
        )
        val pathSegments = relativePath.split("/")

        when {
            pathSegments.isEmpty() -> return@buildAnnotatedString
            pathSegments.size == 1 -> withStyle(
                Theme.typography.caption1r.copy(color = Theme.colors.highlight).toSpanStyle()
            ) {
                append("> ${pathSegments.first()}")
            }
            else -> {
                append("> ")
                pathSegments.dropLast(1).forEach { segment ->
                    append("$segment/")
                }
                withStyle(
                    Theme.typography.caption1r.copy(color = Theme.colors.highlight).toSpanStyle()
                ) {
                    append(pathSegments.last())
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