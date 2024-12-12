package kr.co.seedocs

import android.app.Application
import kr.co.data.di.repositoryModule
import kr.co.database.di.databaseModule
import kr.co.main.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

private val allModules =
    listOf(
        databaseModule,
        repositoryModule,
        mainModule,
    )

class SeeDocs: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@SeeDocs)
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            modules(allModules)
        }
    }
}