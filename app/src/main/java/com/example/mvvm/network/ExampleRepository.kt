package com.example.mvvm.network

import com.example.mvvm.storage.perferences.ExamplePreferences
import com.example.mvvm.storage.perferences.PreferencesModel
import com.example.mvvm.storage.perferences.prefExample
import com.example.mvvm.storage.persistence.ExampleDatabase
import com.example.mvvm.storage.persistence.ExampleEntity

class ExampleRepository(
    private val api: ExampleEndpoint,
    private val pref: ExamplePreferences,
    private val db: ExampleDatabase
) {
    suspend fun fetchGet() = api.exampleGet()
    suspend fun fetchPost() = api.examplePost()

    fun savePreferences(example: String?) {
        pref.put(prefExample, example!!)
    }

    fun getPreferences(): PreferencesModel {
        return PreferencesModel(pref.getString(prefExample))
    }

    suspend fun saveDataUsername(exampleEntity: ExampleEntity) {
        db.exampleData().insert(exampleEntity)
    }

    fun getDataUsername() = db.exampleData().select()
}