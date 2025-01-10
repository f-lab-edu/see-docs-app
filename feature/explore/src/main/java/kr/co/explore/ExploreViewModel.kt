package kr.co.explore

import kr.co.data.repository.RecentRepository
import kr.co.model.ExploreSideEffect
import kr.co.model.ExploreUiIntent
import kr.co.model.ExploreUiState
import kr.co.model.FileInfo
import kr.co.ui.base.BaseMviViewModel
import kr.co.util.FileManagerImpl

internal class ExploreViewModel(
    private val recentRepository: RecentRepository,
    private val fileManagerImpl: FileManagerImpl,
) :
    BaseMviViewModel<ExploreUiState, ExploreUiIntent, ExploreSideEffect>(ExploreUiState.INIT) {

    override fun handleIntent(intent: ExploreUiIntent) {
        when (intent) {
            is ExploreUiIntent.Init -> init(intent.path)
            is ExploreUiIntent.ClickFile -> onClickFile(intent.file)
            is ExploreUiIntent.ClickFolder -> onClickFolder(intent.folder)
        }
    }

    private fun init(path: String) = launch {
        reduce {
            copy(path = path)
        }

        fileManagerImpl.readPDFOrDirectory(path).partition { it.isDirectory }.let { (folders, files) ->
            reduce {
                copy(
                    folders = folders,
                    files = files,
                )
            }
        }
    }

    private fun onClickFile(file: FileInfo) = launch {
        recentRepository.insert(file)
    }.invokeOnCompletion {
        postSideEffect(ExploreSideEffect.NavigateToPdf(file.path))
    }

    private fun onClickFolder(folder: FileInfo) =
        postSideEffect(ExploreSideEffect.NavigateToFolder(folder.path))

}