package com.example.task_manager.application.usecase.notification

import com.example.task_manager.domain.repository.PreferencesRepository
import javax.inject.Inject

class SetNotificationsEnabledUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(enabled: Boolean) {
        preferencesRepository.setNotificationsEnabled(enabled)
    }
}