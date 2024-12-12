package kr.co.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val recentModule =
    module {
        viewModelOf(::RecentViewModel)
    }