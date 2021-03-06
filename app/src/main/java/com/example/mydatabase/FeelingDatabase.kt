package com.example.mydatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// @Database(entities = arrayOf(Feeling::class), version = 1)
@Database(entities = [Feeling::class], version = 1)
abstract class FeelingDatabase : RoomDatabase() {
    //Instance of DAO (to call function)
    abstract fun feelingDao() : FeelingDao

    //Ensure only one instance of the database is created
    companion object {
        //Type of memory - volatile
        @Volatile
        private var INTANCE: FeelingDatabase? = null

        fun getDatabase(context: Context): FeelingDatabase {
            val tempInstance = INTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            //Create an instance of the database
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FeelingDatabase::class.java,
                    "feeling_db"
                ).build()

                INTANCE = instance
                return instance
            }
        }
    }

}