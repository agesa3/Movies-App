package com.beatrice.moviesapp.core.data

import com.beatrice.moviesapp.core.data.models.ChangeListVersions
import logcat.logcat

// TODO: Documentation
interface Synchronizer {
    suspend fun getLatestChangeListVersions(): ChangeListVersions
    suspend fun updateChangeListVersions()

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
        logcat("Exception") { "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result $e" }
        Result.failure(exception = e)
    }

suspend fun Synchronizer.changeListSync() = safeSyncCall {
    /**
     * Update moveLists version.. Only when updating movies has been successful
     * Insert new movies
     * Delete old non-existence movies
     * .. Check if an update is required... this mighty be hard, or even unnecessary
     * if no updates required return true
     */
}




/**
 * suspend fun Synchronizer.changeListSync(
versionReader: (ChangeListVersions) -> Int,
changeListFetcher: suspend (Int) -> List<NetworkChangeList>,
versionUpdater: ChangeListVersions.(Int) -> ChangeListVersions,
modelDeleter: suspend (List<String>) -> Unit,
modelUpdater: suspend (List<String>) -> Unit,
) = suspendRunCatching {
// Fetch the change list since last sync (akin to a git fetch)
val currentVersion = versionReader(getChangeListVersions())
val changeList = changeListFetcher(currentVersion)
if (changeList.isEmpty()) return@suspendRunCatching true

val (deleted, updated) = changeList.partition(NetworkChangeList::isDelete)

// Delete models that have been deleted server-side
modelDeleter(deleted.map(NetworkChangeList::id))

// Using the change list, pull down and save the changes (akin to a git pull)
modelUpdater(updated.map(NetworkChangeList::id))

// Update the last synced version (akin to updating local git HEAD)
val latestVersion = changeList.last().changeListVersion
updateChangeListVersions {
versionUpdater(latestVersion)
}
}.isSuccess
 */