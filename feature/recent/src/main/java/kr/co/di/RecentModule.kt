package kr.co.di

import kr.co.recent.RecentViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val recentModule =
    module {
        viewModel { RecentViewModel(get()) }
    }