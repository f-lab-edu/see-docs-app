package kr.co.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.co.data.repository.BookmarkRepository
import kr.co.model.BookmarkUiState

internal class BookmarkViewModel(
    bookmarkRepository: BookmarkRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(BookmarkUiState.EMPTY)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            bookmarkRepository.get()
                .collectLatest { files ->
                    _uiState.update {
                        it.copy(
                            files = files
                        )
                    }
                }
        }
    }
}