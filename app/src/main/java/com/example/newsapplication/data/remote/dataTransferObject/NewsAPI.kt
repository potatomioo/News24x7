package com.example.newsapplication.data.remote.dataTransferObject

import com.example.newsapplication.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = API_KEY
    ) : NewsResponse

}