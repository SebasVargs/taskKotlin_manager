package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task_manager.ui.onboarding.OnboardingScreen
import com.example.task_manager.ui.screens.home.HomeScreen
import com.example.task_manager.ui.screens.settings.SettingsScreen
import com.example.task_manager.ui.screens.task_detail.TaskDetailScreen
import com.example.task_manager.ui.theme.TaskManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "onboarding") {
                    composable("onboarding") {
                        OnboardingScreen(
                            onOnboardingComplete = {
                                navController.navigate("home") {
                                    popUpTo("onboarding") { inclusive = true }
                                }
                            }
                        )
                    }

                    composable("home") {
                        HomeScreen(
                            onNavigateToSettings = {
                                navController.navigate("settings")
                            },
                            onNavigateToTaskDetail = { taskId ->
                                navController.navigate("taskDetail/$taskId")
                            }
                        )
                    }
                    composable("settings") {
                        SettingsScreen(
                            onBackClick = { navController.popBackStack() }
                        )
                    }

                    composable("taskDetail/{taskId}") { backStackEntry ->
                        val taskId = backStackEntry.arguments?.getString("taskId") ?: "new"
                        TaskDetailScreen(
                            taskId = taskId,
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }
            }
        }

    }
}