package com.medieverone.teststarwarsapi.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.medieverone.data.database.StarWarsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ContextModule::class
])
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): StarWarsDatabase {
        return Room.databaseBuilder(
            context,
            StarWarsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }


    companion object {

        private const val DATABASE_NAME = "star-wars-room-database"
    }
}