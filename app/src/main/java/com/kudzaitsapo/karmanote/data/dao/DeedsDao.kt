package com.kudzaitsapo.karmanote.data.dao

import androidx.room.*
import com.kudzaitsapo.karmanote.models.DeedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeedsDao {

    @Insert
    fun insertDeed(deed: DeedEntity) : Long

    @Delete
    fun delete(deed: DeedEntity)

    @Query("SELECT * FROM deeds WHERE person_id=:personId")
    fun getPersonDeeds(personId: Int) : Flow<List<DeedEntity>>

    @Update
    fun updateDeed(vararg deed: DeedEntity)

}