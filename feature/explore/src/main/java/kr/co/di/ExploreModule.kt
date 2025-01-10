package kr.co.di

import kr.co.explore.ExploreViewModel
import kr.co.util.FileManagerImpl
import kr.co.util.FileManager
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val exploreModule =
    module {
        viewModel {
            ExploreViewModel(
                get(),
                get<FileManagerImpl>(),
            )
        }

        single<FileManager> {
            FileManagerImpl()
        }
    }
