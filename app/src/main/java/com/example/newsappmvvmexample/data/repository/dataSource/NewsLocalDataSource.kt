package com.example.newsappmvvmexample.data.repository.dataSource

import com.example.newsappmvvmexample.data.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/6/22.
 */

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDB(article: Article)
}