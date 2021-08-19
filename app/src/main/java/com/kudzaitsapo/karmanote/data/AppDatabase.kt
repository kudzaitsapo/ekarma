package com.kudzaitsapo.karmanote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kudzaitsapo.karmanote.data.dao.DeedsDao
import com.kudzaitsapo.karmanote.data.dao.PeopleDao
import com.kudzaitsapo.karmanote.models.DeedEntity
import com.kudzaitsapo.karmanote.models.PeopleEntity

@Database(entities = arrayOf(PeopleEntity::class, DeedEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao() : PeopleDao
    abstract fun deedDao() : DeedsDao

    companion object {

        // For Singleton instantiation
        @Volatile private var INSTANCE: AppDatabase? = null


        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "deeds.db"
                    )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }
}
