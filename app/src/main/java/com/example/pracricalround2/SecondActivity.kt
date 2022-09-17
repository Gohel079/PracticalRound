package com.example.pracricalround2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.math.log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent = intent

        val tittle = intent.getStringExtra("tittle")
        val desc = intent.getStringExtra("desc")
        val url = intent.getStringExtra("url")
        val date = intent.getStringExtra("time")

        Log.d("Data",tittle.toString())
        Log.d("Data",desc.toString())
        Log.d("Data",url.toString())
        Log.d("Data",date.toString())


        val tvTittle =  findViewById<TextView>(R.id.LargeTittle)
        val tvDesc =  findViewById<TextView>(R.id.LargeDesc)
        val image =  findViewById<ImageView>(R.id.imgBig)
        val time =  findViewById<TextView>(R.id.LargeTime)


            tvTittle.text = tittle
            tvDesc.text = desc
            time.text=  date

        Glide.with(applicationContext).load(url).into(image)

    }
}