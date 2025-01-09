package kr.co.di

import kr.co.bookmark.BookmarkViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookmarkModule =
    module {
        viewModel { BookmarkViewModel(get()) }
    }
