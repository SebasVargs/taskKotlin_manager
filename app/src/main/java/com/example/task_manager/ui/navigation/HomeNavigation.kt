package com.example.task_manager.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.task_manager.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeGraph(navController: NavController) {
    composable(route = Routes.HOME_SCREEN) {
        HomeScreen(
            onNavigateToSettings = {
                navController.navigate(Routes.SETTINGS_SCREEN)
            },
            onNavigateToTaskDetail = { taskId ->
                navController.navigate("${Routes.TASK_DETAIL_SCREEN}/$taskId")
            }
        )
    }

    // Ruta para detalle de tarea (cuando la implementes)
    composable(route = "${Routes.TASK_DETAIL_SCREEN}/{taskId}") { backStackEntry ->
        val taskId = backStackEntry.arguments?.getString("taskId") ?: ""
        // TODO: Aquí irá TaskDetailScreen cuando lo implementes
        // TaskDetailScreen(
        //     taskId = taskId,
        //     onBackClick = { navController.popBackStack() }
        // )
    }
}