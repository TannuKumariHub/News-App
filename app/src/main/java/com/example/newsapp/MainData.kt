package com.example.newsapp

data class MainData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)