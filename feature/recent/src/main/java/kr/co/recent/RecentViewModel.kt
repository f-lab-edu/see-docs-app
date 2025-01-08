package kr.co.recent

import kotlinx.coroutines.flow.collectLatest
import kr.co.data.repository.RecentRepository
import kr.co.model.RecentUiIntent
import kr.co.model.RecentUiState
import kr.co.ui.base.BaseMviViewModel

internal class RecentViewModel(
    recentRepository : RecentRepository,
) : BaseMviViewModel<RecentUiState, RecentUiIntent>(RecentUiState.INIT) {

    override fun handleIntent(intent: RecentUiIntent) {
        when (intent) {
            is RecentUiIntent.Init -> {}
            is RecentUiIntent.ClickFile -> {}
        }
    }

    init {
        launch {
            recentRepository.get()
                .collectLatest { files ->
                    reduce {
                        copy(
                            files = files
                        )
                    }
                }
        }
    }
}