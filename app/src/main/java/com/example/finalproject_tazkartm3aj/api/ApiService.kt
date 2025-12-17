package com.example.finalproject_tazkartm3aj.api

import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
