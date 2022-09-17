package com.example.pracricalround2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pracricalround2.model.NewsDataModel
import com.example.pracricalround2.network.RetroInstance
import com.example.pracricalround2.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel(){

    lateinit var recyclerListLiveData : MutableLiveData<NewsDataModel>


    init {
        recyclerListLiveData = MutableLiveData()
    }


    fun getListOfDataObserver() : MutableLiveData<NewsDataModel>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {

            val instance = RetroInstance.getInstance().create(RetroService::class.java)
            var response = instance.getDataFtromAPI("sources=techcrunch&apiKey=f70c3813c0fe408790e6c203557f63e5")
            recyclerListLiveData.postValue(response)
        }
    }
}