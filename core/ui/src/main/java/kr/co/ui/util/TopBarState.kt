package kr.co.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.ContinuationInterceptor

class TopBarState private constructor(
    private val scope: CoroutineScope
) {
    var topBarVisible by mutableStateOf(false)
        private set

    private var currentJob: Job? = null

    fun show() {
        currentJob?.cancel()

        currentJob = scope.launch {
            topBarVisible = true
            delay(3000)
            topBarVisible = false
        }
    }

    companion object {
        fun create(scope: CoroutineScope): TopBarState {
            require(scope.coroutineContext[ContinuationInterceptor] is MainCoroutineDispatcher) {
                "TopBar state should be created in main thread"
            }
            return TopBarState(scope)
        }
    }
}

@Composable
fun rememberTopBarState(
    scope: CoroutineScope = rememberCoroutineScope{Dispatchers.Main.immediate}
) : TopBarState =
    remember { TopBarState.create(scope) }