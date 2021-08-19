package com.kudzaitsapo.karmanote.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kudzaitsapo.karmanote.models.PeopleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Insert
    fun insertPerson(person: PeopleEntity) : Long

    @Delete
    fun delete(person: PeopleEntity)

    @Query("SELECT * FROM people")
    fun getAll() : Flow<List<PeopleEntity>>

}