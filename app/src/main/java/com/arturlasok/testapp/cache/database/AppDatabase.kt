package com.arturlasok.testapp.cache.database

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {


    companion object{
        val DATABASE_NAME: String = "testapp_db"
    }

}