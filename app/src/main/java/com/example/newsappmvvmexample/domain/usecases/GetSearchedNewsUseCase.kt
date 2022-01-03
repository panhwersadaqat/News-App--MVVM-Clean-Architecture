package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.repository.NewsRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/3/22.
 */

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchedQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchedQuery)
    }
}