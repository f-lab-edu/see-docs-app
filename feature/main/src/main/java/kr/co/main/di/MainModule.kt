package kr.co.main.di

import kr.co.di.pdfModule
import org.koin.dsl.module

val mainModule =
    module {
        includes(
            pdfModule,
        )
    }