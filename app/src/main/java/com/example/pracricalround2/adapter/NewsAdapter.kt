package com.example.pracricalround2.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pracricalround2.R
import com.example.pracricalround2.SecondActivity
import com.example.pracricalround2.model.NewsDataModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    var item = ArrayList<NewsDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_list_item,parent,false)

        return  MyViewHolder(view,parent)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(item.get(position))

        holder.itemView.setOnClickListener{

            val data = item.get(position)

            var tittle : String = data.title
            var desc : String = data.description
            var imgurl : String = data.urlToImage
            var time : String = data.publishedAt

            var intnet = Intent(holder.mContext,SecondActivity::class.java)
            intnet.putExtra("tittle",tittle)
            intnet.putExtra("desc",desc)
            intnet.putExtra("url",imgurl)
            intnet.putExtra("time",time)

            holder.mContext.startActivity(intnet)
        }
    }

    override fun getItemCount(): Int {
        return  item.size
    }


    class MyViewHolder(view: View, parent: ViewGroup) : RecyclerView.ViewHolder(view)
    {
        val imgThumb = view.findViewById<ImageView>(R.id.img)
        val tittle = view.findViewById<TextView>(R.id.tvTitle)
        val desc = view.findViewById<TextView>(R.id.tvDesc)
        val date = view.findViewById<TextView>(R.id.date)

        val mContext : Context = parent.context

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(data: NewsDataModel) {

            tittle.text = data.title
            desc.text = data.description

            val url = data.urlToImage
            var dateFormate = data.publishedAt

//
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")
            val parsedDate: Date = inputFormat.parse(dateFormate)
            val formattedDate: String = outputFormat.format(parsedDate)
            println(formattedDate)

            date.text = formattedDate
            Glide.with(mContext).load(url).into(imgThumb)
        }

    }

    fun setUpdateData(item: ArrayList<NewsDataModel>){
        this.item = item
        notifyDataSetChanged()
    }
}
