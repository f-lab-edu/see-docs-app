package kr.co.recent

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.model.RecentSideEffect
import kr.co.model.RecentUiIntent
import kr.co.model.RecentUiState
import kr.co.seedocs.feature.recent.R
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import kr.co.ui.util.LaunchIntentHandler
import kr.co.ui.util.LaunchSideEffect
import kr.co.ui.widget.FileBox
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun RecentRoute(
    padding: PaddingValues,
    viewModel: RecentViewModel = koinViewModel(),
    navigateToPdf: (String) -> Unit = {},
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchIntentHandler(RecentUiIntent.Init, viewModel)

    LaunchSideEffect(viewModel) {
        when(it) {
            is RecentSideEffect.NavigateToPdf -> navigateToPdf(it.path)
        }
    }

    RecentScreen(
        padding = padding,
        state = state,
        handleIntent = viewModel::handleIntent
    )
}

@Composable
private fun RecentScreen(
    padding: PaddingValues,
    state: RecentUiState = RecentUiState.INIT,
    handleIntent: (RecentUiIntent) -> Unit = {},
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
                    text = stringResource(R.string.feature_recent_recent),
                    style = Theme.typography.body1sb,
                    color = Theme.colors.text
                )
            }

            items(state.files) { file ->
                FileBox(
                    name = file.name,
                    dateTime = file.createdAt,
                    onFileClick = { handleIntent(RecentUiIntent.ClickFile(file)) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        RecentScreen(
            padding = PaddingValues()
        )
    }
}