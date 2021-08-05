package com.kudzaitsapo.karmanote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kudzaitsapo.karmanote.data.dao.DeedsDao
import com.kudzaitsapo.karmanote.data.dao.PeopleDao
import com.kudzaitsapo.karmanote.models.DeedEntity
import com.kudzaitsapo.karmanote.models.PeopleEntity

@Database(entities = arrayOf(PeopleEntity::class, DeedEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao() : PeopleDao
    abstract fun deedDao() : DeedsDao
}
