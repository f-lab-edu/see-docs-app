package kr.co.di

import kr.co.explore.ExploreViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val exploreModule =
    module {
        viewModel {
            ExploreViewModel(
                get()
            )
        }
    }
