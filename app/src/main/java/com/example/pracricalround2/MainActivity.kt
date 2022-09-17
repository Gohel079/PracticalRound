package com.example.pracricalround2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pracricalround2.adapter.NewsAdapter
import com.example.pracricalround2.model.NewsDataModel
import com.example.pracricalround2.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setViewModel()
    }

    private fun initView() {
        val recyclerView =  findViewById<RecyclerView>(R.id.rvList)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        newsAdapter = NewsAdapter()
        recyclerView.adapter = newsAdapter
    }

    private fun setViewModel() {

        val viewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)


        viewModel.makeApiCall()
        viewModel.getListOfDataObserver().observe(this,Observer<ArrayList<NewsDataModel>>{

            if(it != null){
                newsAdapter.setUpdateData(it)
            }else{
                Toast.makeText(this,"NOT DATA", Toast.LENGTH_SHORT).show()
            }
        })




    }
}