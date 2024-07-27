//package com.example.newsapplication.di
//
//import android.app.Application
//import com.example.newsapplication.data.manager.LocalUserManangerImpl
//import com.example.newsapplication.domain.manager.LocalUserManager
//import com.example.newsapplication.usecase.AppEntryUseCases
//import com.example.newsapplication.usecase.ReadAppEntry
//import com.example.newsapplication.usecase.SaveAppEntry
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideLocalUserManger(
//        application: Application
//    ): LocalUserManager = LocalUserManangerImpl(application)
//
//
//
//    @Provides
//    @Singleton
//    fun provideAppEntryUseCases(
//        localUserManager: LocalUserManager
//    ) = AppEntryUseCases(
//        readAppEntry = ReadAppEntry(localUserManager),
//        saveAppEntry = SaveAppEntry(localUserManager)
//    )
//
//}