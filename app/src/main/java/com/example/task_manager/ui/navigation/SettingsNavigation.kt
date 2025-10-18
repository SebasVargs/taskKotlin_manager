package com.example.task_manager.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.task_manager.ui.screens.settings.SettingsScreen

fun NavGraphBuilder.settingsGraph(navController: NavController) {
    composable(route = Routes.SETTINGS_SCREEN) {
        SettingsScreen(
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}