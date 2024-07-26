package com.example.newsapplication.usecase

import com.example.newsapplication.domain.manager.LocalUserManager

//use case objects
//helpful to structure app and can use in different places where these functions of localUserManager interface will be needed.
//invoke helps to call interface  as function

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}