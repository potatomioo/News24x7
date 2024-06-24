package com.example.newsapplication.presentation.onboarding

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.example.newsapplication.R

data class Page(
    val Title : String,
    val Description : String,
    @DrawableRes val Image : Int
)


val pages = listOf(
    Page(
        Title = "Hey Potatomioo",
        Description = "Wish you a good day",
        Image = R.drawable.night
    ),
    Page(
        Title = "Hey Potatomioo",
        Description = "Wish you a good day",
        Image = R.drawable.Men
    ),
    Page(
        Title = "Hey Potatomioo",
        Description = "Wish you a good day",
        Image = R.drawable.View
    )
)