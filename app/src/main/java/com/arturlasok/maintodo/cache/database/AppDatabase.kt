package com.arturlasok.maintodo.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
/*
@Database(entities = arrayOf(

),
    version = 1,
    exportSchema = true,
    //autoMigrations = [ AutoMigration(from = 18, to = 19, spec = AppDatabase.MyAutoMig::class)]


)
*/
abstract class AppDatabase : RoomDatabase() {


    companion object{
        val DATABASE_NAME: String = "maintodo_db"
    }

}