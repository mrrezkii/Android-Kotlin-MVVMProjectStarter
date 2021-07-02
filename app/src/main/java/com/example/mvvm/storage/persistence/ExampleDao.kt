package com.example.mvvm.storage.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ExampleEntity)

    @Update
    suspend fun update(entity: ExampleEntity)

    @Delete
    suspend fun delete(entity: ExampleEntity)

    @Query("DELETE FROM tableExample")
    suspend fun deleteAll()

    @Query("SELECT * FROM tableExample")
    fun select(): LiveData<List<ExampleEntity>>
}