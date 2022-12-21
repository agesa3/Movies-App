package com.beatrice.moviesapp.core.data

import com.beatrice.moviesapp.core.data.models.ChangeListVersions

// TODO: Documentation
interface Synchronizer{
    suspend fun getLatestChangeListVersions(): ChangeListVersions
    suspend fun updateChangeListVersions()

}
/**
 *
 */
interface Syncable{
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}

/**
 * suspend fun getChangeListVersions(): ChangeListVersions

suspend fun updateChangeListVersions(update: ChangeListVersions.() -> ChangeListVersions)

/**
 * Syntactic sugar to call [Syncable.syncWith] while omitting the synchronizer argument
*/
suspend fun Syncable.sync() = this@sync.syncWith(this@Synchronizer)
 */