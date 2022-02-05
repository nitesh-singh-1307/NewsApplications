package com.demo.newsapplication.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import com.demo.newsapplication.base.BaseViewModel
import com.demo.newsapplication.base.SingleLiveEvent
import com.demo.newsapplication.models.NewsModuls
import kotlinx.coroutines.launch

class NewsViewModel : BaseViewModel() {
    private val _getNationalityOption = SingleLiveEvent<NewsModuls>()
    val getNationalityOption: LiveData<NewsModuls> = _getNationalityOption

    fun getNationalityOption() {
        viewModelScope.launch {
            displayLoader()
            processDataEvent(api1Repository.getNationalityOptions()) {
                _getNationalityOption.postValue(it)
            }
        }
    }
}