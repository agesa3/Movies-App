package com.beatrie.domain.util

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
