package com.example.newsappmvvmexample.data.repository.dataSourceImpl

import com.example.newsappmvvmexample.data.api.NewsAPIService
import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/4/22.
 */

class NewsRemoteDataSourceImpl (
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,page)
    }
}