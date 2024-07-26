package com.example.newsapplication

import androidx.annotation.DrawableRes

data class PageContent(
    val Title : String,
    val Des : String,
    @DrawableRes val Img : Int
)

val pages = listOf(
    PageContent(
        Title = "Hey Potatomioo",
        Des = "Wish you a good day",
        Img = R.drawable.night
    ),
    PageContent(
        Title = "Hey Potatomioo",
        Des = "Wish you a good day",
        Img = R.drawable.men
    ),
    PageContent(
        Title = "Hey Potatomioo",
        Des = "Wish you a good day",
        Img = R.drawable.view
    )
)