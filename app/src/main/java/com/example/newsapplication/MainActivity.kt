package com.example.newsapplication

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.newsapplication.presentation.navgraph.NavGraph
import com.example.newsapplication.presentation.onboarding.components.OnboardingScreen
import com.example.newsapplication.presentation.onboarding.onboardingViewModel.OnboardingViewModel
import com.example.newsapplication.usecase.AppEntryUseCases
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.processor.internal.definecomponent.codegen._dagger_hilt_android_components_ViewModelComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel._splashCondition
            }
        }


        setContent{
            val startDestination = viewModel.startDestination
            NavGraph(startDestination = startDestination)
        }
    }
}

@Preview(name = "Light", showBackground = true, showSystemUi = true)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun final() {

}

// Clean architecture has three layers as Presentation, Data and Domain.
// Presentation is bigger can access data and domain both.
// Data is second layer, only can access domain.
// Domain is the inner layer,can not access any other layer.