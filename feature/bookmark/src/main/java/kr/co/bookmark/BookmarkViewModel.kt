package kr.co.bookmark

import kotlinx.coroutines.flow.collectLatest
import kr.co.data.repository.BookmarkRepository
import kr.co.data.repository.RecentRepository
import kr.co.model.BookmarkSideEffect
import kr.co.model.BookmarkUiIntent
import kr.co.model.BookmarkUiState
import kr.co.model.FileInfo
import kr.co.ui.base.BaseMviViewModel

internal class BookmarkViewModel(
    private val bookmarkRepository: BookmarkRepository,
    private val recentRepository: RecentRepository,
) : BaseMviViewModel<BookmarkUiState, BookmarkUiIntent, BookmarkSideEffect>(BookmarkUiState.INIT) {

    override fun handleIntent(intent: BookmarkUiIntent) {
        when (intent) {
            is BookmarkUiIntent.Init -> init()
            is BookmarkUiIntent.ClickFile -> { onClickFile(intent.file) }
        }
    }

    private fun init() = launch {
        bookmarkRepository.get()
            .collectLatest { files ->
                reduce {
                    copy(
                        files = files
                    )
                }
            }
    }

    private fun onClickFile(file: FileInfo) = launch {
        recentRepository.insert(file)
    }.invokeOnCompletion {
        postSideEffect(BookmarkSideEffect.NavigateToPdf(file.path))
    }
}