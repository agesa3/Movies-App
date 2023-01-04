package com.beatrice.moviesapp

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.beatrice.moviesapp.sync.periodicSyncTask
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger
import logcat.LogPriority
import logcat.logcat
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
        logcat("TAAASKS") { "How many times was I called?" }
        workManager.enqueueUniquePeriodicWork(
            "syncWork", // TODO: Extract to a variable
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