package com.example.concurrencyapp.api

import com.example.concurrencyapp.response.ResponseCoinsList
import com.example.concurrencyapp.response.ResponseDetailsCoin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @GET("/coins/markets?sparkline=true")
    suspend fun getCoinsList(@Query("vs_currency ") vs_currency: String): Response<ResponseCoinsList>

    @GET("coins/{id}?sparkline=true")
    suspend fun getDetailsCoin(@Path("id") id: String) : Response<ResponseDetailsCoin>
}