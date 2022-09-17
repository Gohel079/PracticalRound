package com.example.pracricalround2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pracricalround2.R
import com.example.pracricalround2.model.NewsDataModel

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    var item = ArrayList<NewsDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_list_item,parent,false)

        return  MyViewHolder(view,parent)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(item.get(position))
    }

    override fun getItemCount(): Int {
        return  item.size
    }


    class MyViewHolder(view: View, parent: ViewGroup) : RecyclerView.ViewHolder(view)
    {
        val imgThumb = view.findViewById<ImageView>(R.id.img)
        val tittle = view.findViewById<TextView>(R.id.tvTitle)
        val desc = view.findViewById<TextView>(R.id.tvDesc)

        val mContext : Context = parent.context

        fun bind(data: NewsDataModel) {

            tittle.text = data.title
            desc.text = data.description

            val url = data.urlToImage

            Glide.with(mContext).load(url).into(imgThumb)
        }

    }

    fun setUpdateData(item: ArrayList<NewsDataModel>){
        this.item = item
        notifyDataSetChanged()
    }
}