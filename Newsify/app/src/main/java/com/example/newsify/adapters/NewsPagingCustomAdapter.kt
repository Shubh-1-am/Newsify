package com.example.newsify.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsify.retrofit.response.Article
import com.example.newsify.databinding.NewsItemBinding
import com.example.newsify.BR


class NewsPagingCustomAdapter(val onAdapterClickListener: OnAdapterClickListener) :
    PagingDataAdapter<Article, NewsPagingCustomAdapter.NewsViewHolder>(DIFF_CALLBACK){

        companion object {
            private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
                override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                    return oldItem.url == newItem.url
                }

                override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                    return oldItem == newItem
                }
            }
        }

    inner class NewsViewHolder(val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsPagingCustomAdapter.NewsViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsPagingCustomAdapter.NewsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.binding.setVariable(BR.article, currentItem)
        }
    }
}