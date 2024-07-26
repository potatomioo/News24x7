package com.example.newsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.newsapplication.presentation.onboarding.components.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            OnboardingScreen()
        }
    }
}

@Preview
@Composable
private fun final() {
    OnboardingScreen()
}

// Clean architecture has three layers as Presentation, Data and Domain.
// Presentation is bigger can access data and domain both.
// Data is second layer, only can access domain.
// Domain is the inner layer,can not access any other layer.