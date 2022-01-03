package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.domain.repository.NewsRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/3/22.
 */

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}