package com.example.newsappmvvmexample.data.repository.dataSource

import com.example.newsappmvvmexample.data.model.APIResponse
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/4/22.
 */

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse>
}