package com.example.task_manager.application.usecase.notification

import com.example.task_manager.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotificationsEnabledUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    operator fun invoke(): Flow<Boolean> = preferencesRepository.getNotificationsEnabled()
}