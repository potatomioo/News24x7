package com.example.newsapplication.domain.usecase.app_Entry

import com.example.newsapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}