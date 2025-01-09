package kr.co.data.di

import kr.co.data.mapper.RecentFileMapper
import kr.co.data.repository.RecentRepository
import kr.co.data.repository.RecentRepositoryImpl
import org.koin.dsl.module

val repositoryModule =
    module {

        factory { RecentFileMapper() }

        single<RecentRepository> {
            RecentRepositoryImpl(
                dao = get(),
                mapper = get<RecentFileMapper>()
            )
        }
    }