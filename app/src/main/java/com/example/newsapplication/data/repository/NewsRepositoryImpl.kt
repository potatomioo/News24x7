package com.example.newsapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapplication.data.remote.dataTransferObject.NewsAPI
import com.example.newsapplication.data.remote.dataTransferObject.NewsPagingSource
import com.example.newsapplication.domain.model.Article
import com.example.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsAPI: NewsAPI
) : NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsAPI,
                    sources = sources.joinToString (separator = ",")
                )
            }
        ).flow
    }
}