package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.task_manager.ui.navigation.Routes
import com.example.task_manager.ui.navigation.homeGraph
import com.example.task_manager.ui.navigation.onboardingGraph
import com.example.task_manager.ui.navigation.settingsGraph
import com.example.task_manager.ui.theme.TaskManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val viewModel: MainActivityViewModel = hiltViewModel()

            val hasCompletedOnboarding by viewModel.hasCompletedOnboarding.collectAsState()
            val themeMode by viewModel.themeMode.collectAsState()

            val startDestination = if (hasCompletedOnboarding) {
                Routes.HOME_SCREEN
            } else {
                Routes.ONBOARDING_SCREEN
            }

            TaskManagerTheme(themeMode = themeMode) {
                NavHost(
                    navController = navController,
                    startDestination = startDestination
                ) {
                    onboardingGraph(
                        onOnboardingComplete = {
                            viewModel.completeOnboarding()
                            navController.navigate(Routes.HOME_SCREEN) {
                                popUpTo(Routes.ONBOARDING_SCREEN) { inclusive = true }
                            }
                        }
                    )

                    homeGraph(navController)
                    settingsGraph(navController)
                }
            }
        }
    }
}