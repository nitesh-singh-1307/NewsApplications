package com.demo.newsapplication.ui.newslist

import android.os.Bundle
import android.view.View
import com.demo.newsapplication.R
import com.demo.newsapplication.base.BaseActivity
import com.demo.newsapplication.databinding.ActivityMainBinding
import timber.log.Timber
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager


class NewsActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var notificationAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initS()
        setUpObserver()
        initListeners()
    }

    private fun initListeners() {

    }

    private fun setUpObserver() {
        viewModel.run {
            apiErrors.observe(this@NewsActivity) { handleError(it) }
            appLoader.observe(this@NewsActivity) { updateLoaderUI(it) }
            getNationalityOption.observe(this@NewsActivity) {
                Timber.d("GetNewsData:::::: ${it.articles}")
                if (it.articles.isEmpty()){
                }else{
                    binding.rvNotificationDetail.layoutManager = LinearLayoutManager(this@NewsActivity)
                    binding.rvNotificationDetail.isNestedScrollingEnabled = false
                    notificationAdapter.addAll(it.articles)
                    binding.rvNotificationDetail.adapter = notificationAdapter
                }

            }
        }
    }

    private fun initS() {
        windowsStatusTrensparent()
binding.toolbar.ivBack.visibility = View.INVISIBLE
        notificationAdapter = NewsListAdapter(this@NewsActivity)
        viewModel.getNationalityOption()
    }
}