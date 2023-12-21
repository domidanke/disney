package com.example.disney

import retrofit2.Call
import retrofit2.http.GET


interface DisneyApiService {
    @GET("/character")
    fun fetchData(): Call<DisneyApiCharacterResponse>
}
