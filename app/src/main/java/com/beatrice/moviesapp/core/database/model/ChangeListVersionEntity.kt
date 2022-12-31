package com.beatrice.moviesapp.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: Update migrations
@Entity(tableName = "change_list_version_entity")
data class ChangeListVersionEntity(
    @PrimaryKey
    val movieListVersion: Int = -1
)
