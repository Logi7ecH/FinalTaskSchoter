package com.example.finaltaskschoter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finaltaskschoter.R
import com.example.finaltaskschoter.adapter.NewsAdapter
import com.example.finaltaskschoter.api.RetrofitClient
import com.example.finaltaskschoter.model.News
import com.example.finaltaskschoter.model.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNews()
    }

    private fun showNews() {
        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)
        RetrofitClient.instance.getNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                tvResponseCode.text = response.code().toString()
                val listResponse = response.body()?.articles
                listResponse?.let { list.addAll(it) }
                val adapter = NewsAdapter(list)
                rvUser.adapter = adapter
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }
        })
    }
}