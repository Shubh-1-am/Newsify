package com.example.newsify.retrofit.response

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)