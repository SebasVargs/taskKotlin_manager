package com.example.task_manager.ui.onboarding

import androidx.lifecycle.ViewModel
import com.example.task_manager.R
import com.example.task_manager.ui.onboarding.model.OnboardingPage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class OnboardingUiState(
    val currentPage: Int = 0,
    val totalPages: Int = 0,
    val isLastPage: Boolean = false
)

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    init {
        initializeOnboardingPages()
    }

    private fun initializeOnboardingPages() {
        val totalPages = getOnboardingPages().size
        _uiState.value = _uiState.value.copy(
            totalPages = totalPages,
            isLastPage = false
        )
    }

    fun onPageChanged(pageIndex: Int) {
        val totalPages = getOnboardingPages().size
        val isLastPage = pageIndex == totalPages - 1
        _uiState.value = _uiState.value.copy(
            currentPage = pageIndex,
            isLastPage = isLastPage
        )
    }

    fun getOnboardingPages(): List<OnboardingPage> {
        return listOf(
            OnboardingPage(
                id = 1,
                title = "¡Bienvenido a Syncore!",
                description = "Organiza tus tareas de forma simple y eficiente. Controla cada detalle de tu día.",
                imageRes = R.drawable.ic_launcher_foreground, // Reemplazar con tu drawable
                backgroundColor = 0xFF6366F1
            ),
            OnboardingPage(
                id = 2,
                title = "Crea Tareas Rápidamente",
                description = "Agrega tareas con título, descripción, fecha límite y prioridad. Todo en segundos.",
                imageRes = R.drawable.ic_launcher_foreground, // Reemplazar con tu drawable
                backgroundColor = 0xFF3B82F6
            ),
            OnboardingPage(
                id = 3,
                title = "Organiza por Grupos",
                description = "Clasifica tus tareas en grupos por proyecto, contexto o categoría personal.",
                imageRes = R.drawable.ic_launcher_foreground, // Reemplazar con tu drawable
                backgroundColor = 0xFF6366F1
            ),
            OnboardingPage(
                id = 4,
                title = "Subtareas y Detalles",
                description = "Divide tus tareas en subtareas más pequeñas para un control granular.",
                imageRes = R.drawable.ic_launcher_foreground, // Reemplazar con tu drawable
                backgroundColor = 0xFF3B82F6
            ),
            OnboardingPage(
                id = 5,
                title = "Notificaciones Personalizadas",
                description = "Recibe recordatorios justo cuando los necesites. Configura tu propio ritmo.",
                imageRes = R.drawable.ic_launcher_foreground, // Reemplazar con tu drawable
                backgroundColor = 0xFF6366F1
            )
        )
    }
}