package com.example.myapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapp.model.Affair

@Database(entities = [Affair::class], version = 1, exportSchema = false)
abstract class AffairDatabase : RoomDatabase() {

    abstract fun affairDao(): AffairDao

    companion object {
        @Volatile
        private var INSTANCE: AffairDatabase? = null

        fun getDatabase(context: Context): AffairDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AffairDatabase::class.java,
                    "affair_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}