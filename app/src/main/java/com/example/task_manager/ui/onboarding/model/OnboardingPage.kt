package com.example.task_manager.ui.onboarding.model

import androidx.annotation.DrawableRes

data class OnboardingPage(
    val id: Int,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int,
    val backgroundColor: Long = 0xFFFFFFF
)