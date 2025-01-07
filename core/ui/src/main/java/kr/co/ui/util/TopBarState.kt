package kr.co.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TopBarState(
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
        val Initial = TopBarState(
            scope = CoroutineScope(Job())
        )
    }
}

@Composable
fun rememberTopBarState(
    scope: CoroutineScope = rememberCoroutineScope()
) : TopBarState =
    remember { TopBarState(scope) }