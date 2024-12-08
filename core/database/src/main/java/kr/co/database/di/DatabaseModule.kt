package kr.co.database.di

import android.app.Application
import androidx.room.Room
import kr.co.database.SeeDocsDatabase
import org.koin.dsl.module


val databaseModule =
    module {
        single { provideDatabase(get()) }
        single { provideRecentFileDao(get()) }
    }

private fun provideDatabase(
    application: Application,
): SeeDocsDatabase = Room
    .databaseBuilder(application, SeeDocsDatabase::class.java, "SeeDocs.db")
    .fallbackToDestructiveMigration()
    .build()

private fun provideRecentFileDao(
    database: SeeDocsDatabase,
) = database.recentFileDao()
