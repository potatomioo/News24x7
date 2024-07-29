package com.example.newsapplication.data.manager.remote.dataTransferObject

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)