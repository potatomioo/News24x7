package com.example.newsapplication.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.newsapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapplication.util.Constants
import com.example.newsapplication.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.map


//Data store is a modern API, stores key-value pair
//there is a key defined and add value to it by suspend function
//Read that using flow. That is useful for Asynchronous data change.
//suspend fun is responsible for the Asynchronous Data.

class LocalUserManangerImpl (
    private val context : Context
):LocalUserManager{
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings->
            settings[Prefernceskeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences ->
            //if value is not set, return the false as a default value
            preferences[Prefernceskeys.APP_ENTRY] ?: false
        }
    }

}

//with context we are defining a place to store data
private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

//Basically the keys
private object Prefernceskeys{
    val APP_ENTRY =  booleanPreferencesKey(name = Constants.APP_ENTRY)
}