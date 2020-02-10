package com.onemain.challenge.data

import retrofit2.http.GET


interface DadJokeRetrofitService {
    @GET("/")
    suspend fun nextJoke(): DadJoke
}