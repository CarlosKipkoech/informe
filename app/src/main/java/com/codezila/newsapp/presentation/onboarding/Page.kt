package com.codezila.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.codezila.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int

)

val pages = listOf(
    Page(
        title = "Your World, Your News, Now",
        description = "Experience personalized news coverage tailored to your world, accessible at your fingertips.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Informed, Stay Ahead",
        description = "Empower yourself with real-time updates, expert analysis, and a competitive edge in knowledge.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Instant News, Infinite Insights",
        description = "Access breaking stories in an instant, and unlock a world of limitless perspectives.",
        image = R.drawable.onboarding3
    )
)


