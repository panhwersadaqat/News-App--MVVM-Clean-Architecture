package com.example.newsappmvvmexample.presenter.di

import android.app.Application
import com.example.newsappmvvmexample.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsappmvvmexample.domain.usecases.SaveNewsUseCase
import com.example.newsappmvvmexample.presenter.viewmodel.NewsViewModelFactory
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
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        saveNewsUseCase: SaveNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            saveNewsUseCase
        )
    }
}