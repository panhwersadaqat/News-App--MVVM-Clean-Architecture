package com.example.newsappmvvmexample.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.data.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/3/22.
 */

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}