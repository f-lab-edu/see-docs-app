package kr.co.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kr.co.ui.base.BaseMviViewModel
import kr.co.ui.base.UiIntent
import kr.co.ui.base.UiSideEffect

@Composable
fun <I: UiIntent>LaunchIntentHandler(
    intent: I,
    viewModel: BaseMviViewModel<*, I, *>,
    key: Any = Unit,
) {
    LaunchedEffect(key, intent) {
        viewModel.handleIntent(intent)
    }
}

@Composable
fun <E: UiSideEffect>LaunchSideEffect(
    viewModel: BaseMviViewModel<*, *, E>,
    key: Any = Unit,
    onEffect: suspend (E) -> Unit,
) {
    LaunchedEffect(key) {
        viewModel.sideEffect.collect {
            onEffect(it)
        }
    }
}