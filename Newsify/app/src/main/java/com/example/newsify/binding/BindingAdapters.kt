package com.example.newsify.binding

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsify.R
import com.example.newsify.utils.formatTimeAgo
import javax.inject.Inject

class BindingAdapters @Inject constructor() {

    companion object{
        @BindingAdapter("urlToImage")
        @JvmStatic
        fun loadImage(view: ImageView, url: String?){
            try {
                Glide.with(view.context).setDefaultRequestOptions(RequestOptions())
                    .load(url)
                    .error(R.drawable.news_headlines_1)
                    .into(view)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        @SuppressLint("SimpleDateFormat")
        @BindingAdapter("timeAgoFormat")
        @JvmStatic
        fun convertToTimeAgoFormat(textView: TextView, time: String) {
            try {
                val timeAgo = formatTimeAgo(time)
                textView.text = timeAgo
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}