package com.example.newsappmvvmexample.data.repository.dataSourceImpl

import com.example.newsappmvvmexample.data.db.ArticleDao
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/6/22.
 */

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }
}