package com.example.newsapplication.presentation.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState (initialPage = 0){
            pages.size
        }

        val buttonState = remember{
            derivedStateOf {
                when(pagerState.currentPage){
                    0-> listOf("","Next")
                    1-> listOf("back","Next")
                    2-> listOf("back","Get Started")
                    else -> listOf("","")
                }
            }
        }
        HorizontalPager(state = pagerState) {
            OnboardingPage(modifier = Modifier, page = pages[pagerState.currentPage])
        }
        Spacer(modifier = Modifier.height(1.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .navigationBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            PageIndicator(modifier = Modifier, pageSize = pages.size, selected = pagerState.currentPage)
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                val scope = rememberCoroutineScope()

                if(buttonState.value[0].isNotEmpty()){
                    NewsTextButton(
                        Title = buttonState.value[0]
                    ) {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    }
                }

                NewsButton(
                    Title = buttonState.value[1]
                ) {
                    scope.launch{
                        if(pagerState.currentPage == 3){
                            //to home screen
                        }
                        else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview()
@Composable
private fun Check() {
    OnboardingScreen()
}