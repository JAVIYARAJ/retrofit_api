package com.example.retrofitapi.api

import com.example.retrofitapi.model.QuotesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    //call is class that wrap the api response and you need to check that received response is comes with error or not.

    //if we use coroutines,in that case we don't need to use this call class.
    @GET("/quotes")
    fun getQuote(@Query("page") page: Int): Call<QuotesList>
}