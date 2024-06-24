package com.example.newsapplication.presentation.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapplication.presentation.onboarding.Page
import com.example.newsapplication.presentation.onboarding.pages
import com.example.newsapplication.ui.theme.NewsApplicationTheme

@Composable
fun OnboardingPage(
    night : Boolean = isSystemInDarkTheme(),
    modifier : Modifier,
    page : Page
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.background(
            color = if(night) Color.Black else Color.White
        )
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            painter = painterResource(id = page.Image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = page.Title,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp),
            style = MaterialTheme.typography.titleLarge,
            color = if(isSystemInDarkTheme()) Color.White else Color.Black
        )
        Text(
            text = page.Description,
            modifier = Modifier
                .padding(horizontal = 10.dp),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Normal, fontSize = 15.sp),
            color = if(isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, showSystemUi = true)
@Composable
fun OnboardingPagePreview() {
    NewsApplicationTheme {
        OnboardingPage(modifier = Modifier, page = pages[0])
    }
}