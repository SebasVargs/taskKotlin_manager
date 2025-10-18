package com.example.task_manager.infraestructure.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.task_manager.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

class PreferencesRepositoryImpl(private val context: Context) : PreferencesRepository {

    private val dataStore = context.dataStore

    override fun hasCompletedOnboarding(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[DataStoreKeys.HAS_COMPLETED_ONBOARDING] ?: false
        }
    }

    override suspend fun setOnboardingCompleted() {
        dataStore.edit { preferences ->
            preferences[DataStoreKeys.HAS_COMPLETED_ONBOARDING] = true
        }
    }

    override fun getThemeMode(): Flow<Int> {
        return dataStore.data.map { preferences ->
            preferences[DataStoreKeys.THEME_MODE] ?: 0
        }
    }

    override suspend fun setThemeMode(mode: Int) {
        dataStore.edit { preferences ->
            preferences[DataStoreKeys.THEME_MODE] = mode
        }
    }

    override fun getNotificationsEnabled(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[DataStoreKeys.NOTIFICATIONS_ENABLED] ?: true
        }
    }

    override suspend fun setNotificationsEnabled(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[DataStoreKeys.NOTIFICATIONS_ENABLED] = enabled
        }
    }

    override suspend fun clearAllPreferences() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}