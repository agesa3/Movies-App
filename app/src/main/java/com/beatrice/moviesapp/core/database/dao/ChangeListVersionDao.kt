package com.beatrice.moviesapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.beatrice.moviesapp.core.database.model.ChangeListVersionEntity

@Dao
interface ChangeListVersionDao {
    @Insert(onConflict = REPLACE)
    fun insertVersion(newVersion: ChangeListVersionEntity)

    @Query("SELECT * FROM change_list_version_entity")
    fun getChangeListVersion(): ChangeListVersionEntity

}