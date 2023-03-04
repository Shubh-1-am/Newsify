package com.example.newsify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsify.adapters.OnAdapterClickListener
import com.example.newsify.retrofit.response.Article
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnAdapterClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onAdapterClick(article: Article) {
        TODO("Not yet implemented")
    }


}