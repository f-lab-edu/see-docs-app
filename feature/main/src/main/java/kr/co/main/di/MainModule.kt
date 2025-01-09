package kr.co.main.di

import kr.co.di.recentModule
import kr.co.di.pdfModule
import org.koin.dsl.module

val mainModule =
    module {
        includes(
            recentModule,
            pdfModule,
        )
    }