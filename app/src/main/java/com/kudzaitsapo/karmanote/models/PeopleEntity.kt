package com.kudzaitsapo.karmanote.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PeopleEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val personId: Int = 0,

    @ColumnInfo(name = "full_name")
    val fullName: String

)
