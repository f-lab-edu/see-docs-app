package kr.co.di

import kr.co.pdf.PdfViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val pdfModule =
    module {
        viewModel { PdfViewModel() }
    }