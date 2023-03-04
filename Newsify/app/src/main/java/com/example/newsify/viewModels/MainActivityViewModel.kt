package com.example.newsify.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.newsify.repository.NewsRepository
import com.example.newsify.retrofit.response.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private var currentGeneralNews: Flow<PagingData<Article>>? = null
    private var currentBusinessNews: Flow<PagingData<Article>>? = null
    private var currentEntertainmentNews: Flow<PagingData<Article>>? = null
    private var currentHealthNews: Flow<PagingData<Article>>? = null
    private var currentScienceNews: Flow<PagingData<Article>>? = null
    private var currentSportsNews: Flow<PagingData<Article>>? = null
    private var currentTechnologyNews: Flow<PagingData<Article>>? = null

    suspend fun getGeneralNews(): Flow<PagingData<Article>> {
        val lastResult = currentGeneralNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("general")
            .cachedIn(viewModelScope)
        currentGeneralNews = newResult
        return newResult
    }

    suspend fun getBusinessNews(): Flow<PagingData<Article>> {
        val lastResult = currentBusinessNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("business")
            .cachedIn(viewModelScope)
        currentBusinessNews = newResult
        return newResult
    }

    suspend fun getEntertainmentNews(): Flow<PagingData<Article>> {
        val lastResult = currentEntertainmentNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("entertainment")
            .cachedIn(viewModelScope)
        currentEntertainmentNews = newResult
        return newResult
    }

    suspend fun getHealthNews(): Flow<PagingData<Article>> {
        val lastResult = currentHealthNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("health")
            .cachedIn(viewModelScope)
        currentHealthNews = newResult
        return newResult
    }

    suspend fun getScienceNews(): Flow<PagingData<Article>> {
        val lastResult = currentScienceNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("science")
            .cachedIn(viewModelScope)
        currentScienceNews = newResult
        return newResult
    }

    suspend fun getSportsNews(): Flow<PagingData<Article>> {
        val lastResult = currentSportsNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("sports")
            .cachedIn(viewModelScope)
        currentSportsNews = newResult
        return newResult
    }

    suspend fun getTechnologyNews(): Flow<PagingData<Article>> {
        val lastResult = currentTechnologyNews
        if (lastResult != null) {
            return lastResult
        }
        val newResult = newsRepository.getNews("tech")
            .cachedIn(viewModelScope)
        currentTechnologyNews = newResult
        return newResult
    }
}


