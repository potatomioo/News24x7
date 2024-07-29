package com.example.newsapplication.domain.repository

import androidx.paging.PagingData
import com.example.newsapplication.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>

}