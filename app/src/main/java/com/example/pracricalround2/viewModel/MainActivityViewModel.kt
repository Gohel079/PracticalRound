package com.example.pracricalround2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pracricalround2.model.NewsDataModel
import com.example.pracricalround2.network.RetroInstance
import com.example.pracricalround2.network.RetroService
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel(){

    lateinit var recyclerListLiveData : MutableLiveData<ArrayList<NewsDataModel>>


    init {
        recyclerListLiveData = MutableLiveData()
    }


    fun getListOfDataObserver() : MutableLiveData<ArrayList<NewsDataModel>>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {

            val instance = RetroInstance.getInstance().create(RetroService::class.java)
            var response = instance.getDataFtromAPI("sources=techcrunch&apiKey=f70c3813c0fe408790e6c203557f63e5")
            val gson = Gson().fromJson(response,JsonObject::class.java)
            recyclerListLiveData.postValue(gson.get("articles") as ArrayList<NewsDataModel>)

        }
    }
}