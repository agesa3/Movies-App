package com.beatrice.moviesapp.sync

import android.content.Context
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkerParameters
import com.beatrice.moviesapp.core.data.Synchronizer
import com.beatrice.moviesapp.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import logcat.logcat
import java.util.concurrent.TimeUnit

class SyncWorker(
    context: Context,
    params: WorkerParameters,
    private val moviesRepository: MovieRepository
) : CoroutineWorker(context, params), Synchronizer {
    override suspend fun doWork(): Result {
        logcat("TAAASKS"){"do work getting started≠"}
        moviesRepository.sync()
        return Result.success()
//      return  withContext(Dispatchers.IO) {
//            logcat("TAAASKS"){"do work"}
//            val syncSuccess = awaitAll(
//                async { moviesRepository.sync() }
//            ).all { it }
//            logcat("TAAASKS"){"sync success? $syncSuccess"}
//            if (syncSuccess) Result.success()
//            else Result.retry()
//        }
    }

}

val workerConstraints = Constraints.Builder().apply {
    setRequiredNetworkType(NetworkType.CONNECTED)
    setRequiresBatteryNotLow(true)
    setRequiresStorageNotLow(true)
}.build()

/**
 * Schedule worker to periodically fetch movies and sync the local storage
 */
val periodicSyncTask = PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES)
//    .setConstraints(workerConstraints)
    .build()
val oneTimeTask = OneTimeWorkRequestBuilder<SyncWorker>().build()