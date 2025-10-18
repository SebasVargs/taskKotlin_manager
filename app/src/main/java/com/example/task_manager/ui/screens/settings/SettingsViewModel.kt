package com.example.task_manager.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task_manager.application.usecase.notification.GetNotificationsEnabledUseCase
import com.example.task_manager.application.usecase.notification.SetNotificationsEnabledUseCase
import com.example.task_manager.application.usecase.settings.GetThemeModeUseCase
import com.example.task_manager.application.usecase.settings.SetThemeModeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getThemeModeUseCase: GetThemeModeUseCase,
    private val setThemeModeUseCase: SetThemeModeUseCase,
    private val getNotificationsEnabledUseCase: GetNotificationsEnabledUseCase,
    private val setNotificationsEnabledUseCase: SetNotificationsEnabledUseCase
) : ViewModel() {

    val themeMode = getThemeModeUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    val notificationsEnabled = getNotificationsEnabledUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = true
        )

    fun setThemeMode(mode: Int) {
        viewModelScope.launch {
            setThemeModeUseCase(mode)
        }
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        viewModelScope.launch {
            setNotificationsEnabledUseCase(enabled)
        }
    }

    fun getThemeName(mode: Int): String {
        return when (mode) {
            0 -> "Sistema"
            1 -> "Claro"
            2 -> "Oscuro"
            else -> "Sistema"
        }
    }
}