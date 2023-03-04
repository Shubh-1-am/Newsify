package com.example.newsify.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsify.paging.NewsPagingSource
import com.example.newsify.retrofit.api.ApiService
import com.example.newsify.retrofit.response.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class NewsRepository @Inject constructor(private val apiService: ApiService) {

        suspend fun getNews(category: String): Flow<PagingData<Article>> {
            return Pager(
                config = PagingConfig(pageSize = 20, enablePlaceholders = false),
                pagingSourceFactory = { NewsPagingSource(apiService, category) }
            ).flow
        }
    }



