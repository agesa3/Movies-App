package com.beatrice.moviesapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
