package kr.co.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.co.seedocs.core.ui.BuildConfig
import timber.log.Timber

abstract class BaseMviViewModel<S : UiState, I : UiIntent>(initialState: S) : ViewModel() {
    private val logTag = javaClass.simpleName

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    abstract fun handleIntent(intent: I)

    protected inline fun launch(crossinline block: suspend CoroutineScope.() -> Unit): Job =
        viewModelScope.launch {
            block()
        }

    protected fun update(
        block: S.() -> S
    ) {
        _uiState.update(block)
    }

    protected fun <T> Flow<T>.debugLog(subject: String): Flow<T> =
        if (BuildConfig.DEBUG) {
            onEach { Timber.tag(logTag).d("$subject: $it") }
        } else {
            this
        }

    protected fun <T> T.debugLog(subject: String): T =
        if (BuildConfig.DEBUG) {
            also { Timber.tag(logTag).d("$subject: $this") }
        } else {
            this
        }
}