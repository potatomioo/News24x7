package com.example.newsapplication.domain.usecase.news

import androidx.paging.PagingData
import com.example.newsapplication.data.remote.dataTransferObject.NewsPagingSource
import com.example.newsapplication.domain.model.Article
import com.example.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>) : Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}