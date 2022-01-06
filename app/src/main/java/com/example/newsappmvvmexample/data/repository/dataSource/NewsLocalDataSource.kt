package com.example.newsappmvvmexample.data.repository.dataSource

import com.example.newsappmvvmexample.data.model.Article

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/6/22.
 */

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}