package com.example.pracricalround2.network

import com.example.pracricalround2.model.NewsDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {


        @GET(value = "top-headlines")
        suspend fun getDataFtromAPI(@Query(value = "sources=techcrunch&apiKey=f70c3813c0fe408790e6c203557f63e5") query: String) : String


}