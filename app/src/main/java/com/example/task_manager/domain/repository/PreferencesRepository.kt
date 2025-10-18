package com.example.task_manager.domain.repository

import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {

    // Onboarding
    fun hasCompletedOnboarding(): Flow<Boolean>
    suspend fun setOnboardingCompleted()

    // Tema (0 = Sistema, 1 = Claro, 2 = Oscuro)
    fun getThemeMode(): Flow<Int>
    suspend fun setThemeMode(mode: Int)

    // Notificaciones
    fun getNotificationsEnabled(): Flow<Boolean>
    suspend fun setNotificationsEnabled(enabled: Boolean)

    // Limpiar todas las preferencias
    suspend fun clearAllPreferences()
}