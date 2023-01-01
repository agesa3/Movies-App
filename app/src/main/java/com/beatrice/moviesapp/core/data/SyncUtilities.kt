package com.beatrice.moviesapp.core.data

import logcat.logcat

/**
 * Interface marker for a class that manages synchronization between local data and a remote
 * source for a [Syncable].
 */
interface Synchronizer {
    /**
     * Syntactic sugar to call [Syncable.syncWith] while omitting the synchronizer argument
     */
    suspend fun Syncable.sync() = this@sync.syncWith(this@Synchronizer)
}

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

/**
 * FIXME: Do I need the Synchronizer receiver
 * I mighty remove it
 */
suspend fun<T> Synchronizer.changeListSync(
    itemsFetcher: suspend () -> Result<T?>,
    changeListFetcher: suspend (T?) -> (Map<String, List<Any>?>),
    modelUpdater: suspend  (Map<String, List<Any>?>)-> Unit,
) = safeSyncCall {
    // Fetch items from the network
    val result = itemsFetcher()
    if (result.isFailure) return@safeSyncCall true

    // Prepare the change list before update local data sources
    val changeList = changeListFetcher(result.getOrNull())
    modelUpdater(changeList)

}.isSuccess


