package com.example.task_manager.ui.onboarding

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.task_manager.ui.onboarding.components.OnboardingCarousel

@Composable
fun OnboardingScreen(
    onOnboardingComplete: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val pages = viewModel.getOnboardingPages()

    OnboardingCarousel(
        pages = pages,
        onLastPageReached = onOnboardingComplete,
        modifier = modifier
    )
}