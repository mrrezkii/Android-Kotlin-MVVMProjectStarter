package com.example.mvvm.storage.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ExampleEntity::class],
    exportSchema = false,
    version = 1
)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao

    companion object {
        @Volatile
        private var instance: ExampleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ExampleDatabase::class.java, "ExampleDatabase.db"
            )
                .allowMainThreadQueries()
                .build()
    }
}