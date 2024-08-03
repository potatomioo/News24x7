package com.example.newsapplication.di

import android.app.Application
import com.example.newsapplication.data.manager.LocalUserManangerImpl
import com.example.newsapplication.data.remote.dataTransferObject.NewsAPI
import com.example.newsapplication.data.repository.NewsRepositoryImpl
import com.example.newsapplication.domain.manager.LocalUserManager
import com.example.newsapplication.domain.repository.NewsRepository
import com.example.newsapplication.domain.usecase.app_Entry.AppEntryUseCases
import com.example.newsapplication.domain.usecase.app_Entry.ReadAppEntry
import com.example.newsapplication.domain.usecase.app_Entry.SaveAppEntry
import com.example.newsapplication.domain.usecase.news.GetNews
import com.example.newsapplication.domain.usecase.news.NewsUseCases
import com.example.newsapplication.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManangerImpl(application)



    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsAPI: NewsAPI
    ):NewsRepository = NewsRepositoryImpl(newsAPI)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}