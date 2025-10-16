package com.example.task_manager.ui.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.task_manager.ui.onboarding.OnboardingScreen

fun NavGraphBuilder.onboardingGraph(
    onOnboardingComplete: () -> Unit
) {
    composable(
        route = OnboardingRoutes.ONBOARDING_SCREEN
    ) {
        OnboardingScreen(
            onOnboardingComplete = onOnboardingComplete
        )
    }
}

object OnboardingRoutes {
    const val ONBOARDING_SCREEN = "onboarding_screen"
}