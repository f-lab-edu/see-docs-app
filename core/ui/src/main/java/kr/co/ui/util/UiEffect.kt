package kr.co.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kr.co.ui.base.BaseMviViewModel
import kr.co.ui.base.UiIntent
import kr.co.ui.base.UiSideEffect
import kr.co.ui.base.UiState

@Composable
fun <S: UiState, I: UiIntent, E: UiSideEffect>LaunchIntentHandler(
    intent: I,
    viewModel: BaseMviViewModel<S, I, E>,
    key: Any = Unit,
) {
    LaunchedEffect(key, intent) {
        viewModel.handleIntent(intent)
    }
}

@Composable
fun <S: UiState, I: UiIntent, E: UiSideEffect>LaunchSideEffect(
    viewModel: BaseMviViewModel<S, I, E>,
    key: Any = Unit,
    onEffect: suspend (E) -> Unit,
) {
    LaunchedEffect(key) {
        viewModel.sideEffect.collect {
            onEffect(it)
        }
    }
}

@Composable
fun <T> UiEffect(
    stream: Flow<T>,
    key: Any = Unit,
    onEffect: suspend (T) -> Unit,
) {
    LaunchedEffect(key) {
        stream.collect {
            onEffect(it)
        }
    }
}