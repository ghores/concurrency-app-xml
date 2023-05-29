package com.example.concurrencyapp.api

import com.example.concurrencyapp.response.ResponseCoinsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("/coins/markets?sparkline=true")
    suspend fun getCoinsList(@Query("vs_currency ") vs_currency: String): Response<ResponseCoinsList>
}