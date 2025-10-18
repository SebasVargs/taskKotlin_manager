package com.example.task_manager.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.task_manager.ui.onboarding.OnboardingScreen

fun NavGraphBuilder.onboardingGraph(
    onOnboardingComplete: () -> Unit
) {
    composable(route = Routes.ONBOARDING_SCREEN) {
        OnboardingScreen(
            onOnboardingComplete = onOnboardingComplete
        )
    }
}