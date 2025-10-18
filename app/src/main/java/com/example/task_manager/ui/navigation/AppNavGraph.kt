package com.example.task_manager.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

// Esta función es opcional, puedes llamar directamente a las extensiones
// desde MainActivity como ya lo estás haciendo
fun NavGraphBuilder.setupNavGraph(
    navController: NavController,
    onOnboardingComplete: () -> Unit
) {
    onboardingGraph(onOnboardingComplete)
    homeGraph(navController)
    settingsGraph(navController)
}