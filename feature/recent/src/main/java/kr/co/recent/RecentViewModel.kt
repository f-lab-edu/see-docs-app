package kr.co.recent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kr.co.data.repository.RecentRepository
import kr.co.model.RecentUiState

internal class RecentViewModel(
    recentRepository : RecentRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecentUiState.EMPTY)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            recentRepository.get()
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