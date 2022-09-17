package com.example.pracricalround2.network

import com.example.pracricalround2.model.NewsDataModel
import com.example.pracricalround2.model.Status
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface RetroService {


        @GET(value = "top-headlines")
        suspend fun getDataFtromAPI(@Query("sources")  param1 :String,
                                    @Query("apiKey")  param2 :String): Status


}