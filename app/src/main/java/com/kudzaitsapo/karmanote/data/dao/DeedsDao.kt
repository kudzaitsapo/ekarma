package com.kudzaitsapo.karmanote.data.dao

import androidx.room.*
import com.kudzaitsapo.karmanote.models.DeedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeedsDao {

    @Insert
    fun insertDeed(vararg deed: DeedEntity)

    @Delete
    fun delete(deed: DeedEntity)

    @Query("SELECT * FROM deeds WHERE person_id=:personId")
    fun getPersonDeeds(personId: Int) : Flow<DeedEntity>

    @Update
    fun updateDeed(vararg deed: DeedEntity)

}