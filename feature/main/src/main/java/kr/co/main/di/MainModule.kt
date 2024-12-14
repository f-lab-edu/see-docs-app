package kr.co.main.di

import kr.co.di.bookmarkModule
import kr.co.di.recentModule
import org.koin.dsl.module

val mainModule =
    module {
        includes(
            recentModule,
            bookmarkModule,
        )
    }