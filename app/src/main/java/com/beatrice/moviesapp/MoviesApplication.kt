package com.beatrice.moviesapp

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.example.sync.workers.periodicSyncTask
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import javax.inject.Inject


@HiltAndroidApp
class MoviesApplication : Application(), Configuration.Provider {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }


    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.DEBUG)
        schedulePeriodicTask()
    }
    private fun schedulePeriodicTask() {
        workManager.enqueueUniquePeriodicWork(
            "syncWork",
            ExistingPeriodicWorkPolicy.KEEP,
            periodicSyncTask,
        )
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}