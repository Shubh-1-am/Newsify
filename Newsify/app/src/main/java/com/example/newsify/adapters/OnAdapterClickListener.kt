package com.example.newsify.adapters

import com.example.newsify.retrofit.response.Article

interface OnAdapterClickListener {
    fun onAdapterClick(article : Article);
}