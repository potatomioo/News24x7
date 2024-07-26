package com.example.newsapplication.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newsapplication.ui.theme.BaseBlue
import com.example.newsapplication.ui.theme.BaseGrey

@Composable
fun PageIndicator(
    modifier : Modifier,
    pageSize : Int,
    selected : Int,
    SelectedColor : Color = BaseBlue,
    UnselectedColor : Color = BaseGrey,
    IndicatorSize : Dp = 14.dp
) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        repeat(pageSize){
            page-> 
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(color = if (selected == page) SelectedColor else UnselectedColor)
            )
        }
    }
}

//@Preview
//@Composable
//private fun Indicator() {
//    PageIndicator(modifier = Modifier, pageSize = pages.size, selected = 0)
//}