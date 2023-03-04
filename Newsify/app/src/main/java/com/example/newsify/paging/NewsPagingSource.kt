package com.example.newsify.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsify.retrofit.api.ApiService
import com.example.newsify.retrofit.response.Article
import com.example.newsify.utils.Constants
import retrofit2.HttpException

const val STARTING_PAGE_INDEX = 1
class NewsPagingSource (private val apiService: ApiService,
                        private val category: String
) : PagingSource<Int, Article>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = apiService.getTopHeadlines("in", category, position, params.loadSize, Constants.API_KEY)
            val articles = response.articles
            LoadResult.Page(
                data = articles,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (articles.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition
    }
}