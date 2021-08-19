package com.kudzaitsapo.karmanote.di

import android.content.Context
import androidx.room.Room
import com.kudzaitsapo.karmanote.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

    @Singleton
    @Provides
    fun providePersonDAO(db: AppDatabase) = db.personDao()

    @Singleton
    @Provides
    fun provideDeedsDAO(db: AppDatabase) = db.deedDao()

}