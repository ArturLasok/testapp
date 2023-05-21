package com.arturlasok.testapp.di

import androidx.room.Room
import com.arturlasok.testapp.BaseApplication
import com.arturlasok.testapp.cache.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDb(app: BaseApplication): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }


    /*
    @Singleton
    @Provides
    fun provideProduktDao(db: AppDatabase): ProduktDao {
        return db.produktDao()
    }
    */

}