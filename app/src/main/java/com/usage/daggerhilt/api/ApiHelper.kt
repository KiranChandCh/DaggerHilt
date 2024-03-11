package com.usage.daggerhilt.api

import com.usage.daggerhilt.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}
