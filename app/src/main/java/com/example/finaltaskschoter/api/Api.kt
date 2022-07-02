package com.example.finaltaskschoter.api

import com.example.finaltaskschoter.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("top-headlines?country=id&apiKey=9afff28fc9b64b5ea77978711ac42a9d")
    fun getNews(): Call<NewsResponse>
}