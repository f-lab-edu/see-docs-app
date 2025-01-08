package kr.co.recent

import kotlinx.coroutines.flow.collectLatest
import kr.co.data.repository.RecentRepository
import kr.co.model.FileInfo
import kr.co.model.RecentSideEffect
import kr.co.model.RecentUiIntent
import kr.co.model.RecentUiState
import kr.co.ui.base.BaseMviViewModel

internal class RecentViewModel(
    private val recentRepository : RecentRepository,
) : BaseMviViewModel<RecentUiState, RecentUiIntent, RecentSideEffect>(RecentUiState.INIT) {

    override fun handleIntent(intent: RecentUiIntent) {
        when (intent) {
            is RecentUiIntent.ClickFile -> { onClickFile(intent.file) }
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

    private fun onClickFile(file: FileInfo) = launch {
        recentRepository.insert(file)
    }.invokeOnCompletion {
        postSideEffect(RecentSideEffect.NavigateToPdf(file.path))
    }
}