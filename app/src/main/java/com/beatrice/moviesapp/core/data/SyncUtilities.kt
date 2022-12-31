package com.beatrice.moviesapp.core.data

import com.beatrice.moviesapp.core.data.models.ChangeListVersions
import logcat.logcat

// TODO: Documentation
interface Synchronizer {
    suspend fun getLatestChangeListVersions(): ChangeListVersions
    suspend fun updateChangeListVersions()

    // TODO: Add the last part

}

/**
 *
 */
interface Syncable {
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}

private suspend fun <T> safeSyncCall(block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Exception) {
        logcat("Exception") { "Failed with an exception $e" }
        Result.failure(exception = e)
    }

suspend fun<T> Synchronizer.changeListSync( // TODO: Rename
    versionReader: () -> Int,
    itemsFetcher: suspend () -> Result<T>,
    modelDeleter: suspend (Result<T>) -> Unit,
    modelUpdater: suspend (Result<T>) -> Unit,
    versionUpdater: (Int) -> Unit
) = safeSyncCall {
    /**
     * Pseudo code
     * 1. Get the latest version.
     *     How am I saving the versions? Probably a database table
     * 2. Comparison:
     *      Are there new movies.
     *      Old ones to be deleted
     *      old ones to be updated... All the time this should happen
     *      this forms my change
     *
     * 3. Make the updates
     * 4. Return succes or failure
    */
    val currentVersion = versionReader()
    val result = itemsFetcher()
    if (result.isFailure) return@safeSyncCall true

    modelUpdater(result)
    modelDeleter(result)


    // TODO: Update the last version
}.isSuccess


