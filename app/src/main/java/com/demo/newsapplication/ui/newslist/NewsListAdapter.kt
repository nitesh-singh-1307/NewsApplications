package com.demo.newsapplication.ui.newslist

import android.view.View
import coil.load
import com.bumptech.glide.Glide
import com.demo.newsapplication.R
import com.demo.newsapplication.base.BaseAdapter
import com.demo.newsapplication.databinding.NewsListItemsBinding
import com.demo.newsapplication.models.Article
import com.demo.newsapplication.models.NewsModuls
import timber.log.Timber

class NewsListAdapter(val mcontect : NewsActivity) : BaseAdapter<NewsListItemsBinding, Article>(R.layout.news_list_items) {
    override fun setClickableView(binding: NewsListItemsBinding): List<View?> {
        return when (binding) {is NewsListItemsBinding -> {
                listOf(binding.notificationConstraint)
            }
            else -> listOf(binding.root)
        }
    }

    override fun onBind(
        binding: NewsListItemsBinding,
        position: Int,
        item: Article,
        payloads: MutableList<Any>?
    ) {

        binding.run {
            Timber.d("Newsimage:::::: ${item.urlToImage}")
//                    Glide.with(mcontect).load(item.urlToImage).into(imgNews)

            if (!item.urlToImage.isNullOrEmpty()) {
                imgNews.load(item.urlToImage) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }

            if (!item.title.isNullOrEmpty()){
                tvtNewsTitle.text = item.title
            }
        }
    }

}