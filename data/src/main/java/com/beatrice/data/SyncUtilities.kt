package com.beatrice.data

import logcat.logcat

private suspend fun <T> safeSyncCall(block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: Exception) {
        logcat("Syncing") {"Exception $e"}
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


