package com.example.mvvm.network

class ExampleRepository(
    private val api: ExampleEndpoint,
) {
    suspend fun fetchGet() = api.exampleGet()
    suspend fun fetchPost() = api.examplePost()
}