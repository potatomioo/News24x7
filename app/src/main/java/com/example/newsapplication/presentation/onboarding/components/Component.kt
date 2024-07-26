package com.example.newsapplication.presentation.onboarding.components

import android.content.res.Configuration
import android.graphics.pdf.PdfDocument.Page
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapplication.PageContent
import com.example.newsapplication.pages

@Composable
fun OnboardingPage(
    night: Boolean = isSystemInDarkTheme(),
    modifier: Modifier,
    page: PageContent
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight(0.9f)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            painter = painterResource(id = page.Img),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = page.Title,
            modifier = Modifier
                .padding(top = 0.dp,bottom = 5.dp, start = 20.dp, end = 20.dp),
            style = MaterialTheme.typography.titleLarge,
            color = if(isSystemInDarkTheme()) Color.White else Color.Black
        )
        Text(
            text = page.Des,
            modifier = Modifier
                .padding(top = 0.dp,bottom = 10.dp, start = 20.dp, end = 20.dp),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Normal, fontSize = 15.sp),
            color = if(isSystemInDarkTheme()) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun OnboardingPagePreview() {
//        OnboardingPage(modifier = Modifier, page = pages[0])
//}