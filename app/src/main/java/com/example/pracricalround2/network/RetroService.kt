package com.example.pracricalround2.network

import com.example.pracricalround2.model.NewsDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {


        @GET(value = "top-headlines")
        suspend fun getDataFtromAPI(@Query(value = "q") query: String) : NewsDataModel


}