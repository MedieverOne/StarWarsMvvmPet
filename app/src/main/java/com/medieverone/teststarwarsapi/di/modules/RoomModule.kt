package com.medieverone.teststarwarsapi.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.medieverone.data.database.ImagesDatabase
import com.medieverone.data.database.StarWarsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [
    ContextModule::class
])
class RoomModule {

    @Provides
    @Singleton
    @StarWarsDatabaseAnnotation
    fun provideStarWarsDatabase(context: Context): StarWarsDatabase {
        return Room.databaseBuilder(
            context,
            StarWarsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    @ImagesDatabaseAnnotation
    fun provideImagesDatabase(context: Context): ImagesDatabase {
        return Room.databaseBuilder(
            context,
            ImagesDatabase::class.java,
            IMAGES_DATABASE_NAME
        ).build()
    }


    companion object {

        private const val DATABASE_NAME = "star-wars-room-database"
        private const val IMAGES_DATABASE_NAME = "images_room-database"
    }
}

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class StarWarsDatabaseAnnotation

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class ImagesDatabaseAnnotation