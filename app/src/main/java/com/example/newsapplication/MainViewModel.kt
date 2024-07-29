package com.example.newsapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.presentation.navgraph.Route
import com.example.newsapplication.domain.usecase.app_Entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel(){

    var _splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldWeStartFromHomeScreen ->
            if(shouldWeStartFromHomeScreen){
                startDestination = Route.NewsNavigation.route
            }
            else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(
                300
            )
            _splashCondition = false
        }.launchIn(viewModelScope)
    }
}