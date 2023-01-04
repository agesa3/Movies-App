package com.beatrice.moviesapp.core.data

import logcat.logcat

/**
 * Interface marker for a class that synchronizes with a remote sources.
 *
 */
interface Syncable {
    /**
     * Synchronizes local database with data from remote sources
     * Returns true when the sync is successful
     */
    suspend fun sync(): Boolean
}


private suspend fun <T> safeSyncCall(block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Exception) {
        logcat("Exception") { "Failed with an exception $e" }
        Result.failure(exception = e)
    }


suspend fun <T> changeListSync(
    itemsFetcher: suspend () -> Result<T?>,
    changeListFetcher: suspend (T?) -> (Map<String, List<Any>?>),
    modelUpdater: suspend (Map<String, List<Any>?>) -> Unit,
) = safeSyncCall {
    /**
     *  Fetch items from the network
     */
    val result = itemsFetcher()
    if (result.isFailure) return@safeSyncCall false

    /**
     * Prepare the change list before update local data sources
     */
    val changeList = changeListFetcher(result.getOrNull())
    /**
     * Update local data source
     */
    modelUpdater(changeList)

}.isSuccess


