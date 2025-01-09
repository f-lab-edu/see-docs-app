package kr.co.data.di

import kr.co.data.mapper.BookmarkMapper
import kr.co.data.mapper.FileInfoMapper
import kr.co.data.mapper.RecentFileMapper
import kr.co.data.repository.BookmarkRepository
import kr.co.data.repository.BookmarkRepositoryImpl
import kr.co.data.repository.RecentRepository
import kr.co.data.repository.RecentRepositoryImpl
import org.koin.dsl.module

val repositoryModule =
    module {

        factory { RecentFileMapper() }
        factory { BookmarkMapper() }
        factory { FileInfoMapper() }

        single<RecentRepository> {
            RecentRepositoryImpl(
                dao = get(),
                toRecent = get<RecentFileMapper>(),
                toFileInfo = get<FileInfoMapper>()
            )
        }

        single<BookmarkRepository> {
            BookmarkRepositoryImpl(
                dao = get(),
                toBookmark = get<BookmarkMapper>(),
                toFileInfo = get<FileInfoMapper>()
            )
        }
    }