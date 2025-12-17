package com.example.finalproject_tazkartm3aj.api

class UserRepository(private val api: ApiService) {
    suspend fun getUsers(): List<User> = api.getUsers()
}
