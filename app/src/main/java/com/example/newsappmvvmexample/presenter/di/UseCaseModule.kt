package com.example.newsappmvvmexample.presenter.di

import com.example.newsappmvvmexample.domain.repository.NewsRepository
import com.example.newsappmvvmexample.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsappmvvmexample.domain.usecases.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/4/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsheadLinesUseCase(
        newsRepository: NewsRepository
    ):GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
     fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
     ): SaveNewsUseCase {
         return SaveNewsUseCase(newsRepository)
     }
}