package com.example.finaltaskschoter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finaltaskschoter.R
import com.example.finaltaskschoter.model.News
import kotlinx.android.synthetic.main.item_list.view.*

class NewsAdapter (private val list: ArrayList<News>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(news: News){
            with(itemView){
                val text = "Author: ${news.author}\n" +
                        "${news.title}\n" +
                        "${news.description}\n" +
                        "${news.content}"
                tvResponse.text = text

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}