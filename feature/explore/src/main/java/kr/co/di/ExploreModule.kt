package kr.co.di

import kr.co.explore.ExploreViewModel
import kr.co.util.FileManager
import kr.co.util.IFileManager
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val exploreModule =
    module {
        viewModel {
            ExploreViewModel(
                get(),
                get<FileManager>(),
            )
        }

        single<IFileManager> {
            FileManager()
        }
    }
