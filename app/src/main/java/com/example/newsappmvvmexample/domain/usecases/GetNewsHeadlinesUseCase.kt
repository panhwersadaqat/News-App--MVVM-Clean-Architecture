package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.repository.NewsRepository
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/3/22.
 */

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}