package com.example.newsappmvvmexample.data.repository

import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/4/22.
 */

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
):NewsRepository {
    override suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    private fun responseToResource(response:Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
       return newsLocalDataSource.getSavedArticles()
    }
}