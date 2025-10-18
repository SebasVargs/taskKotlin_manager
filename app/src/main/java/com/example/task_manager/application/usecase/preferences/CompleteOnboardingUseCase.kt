package com.example.task_manager.application.usecase.preferences

import com.example.task_manager.domain.repository.PreferencesRepository
import javax.inject.Inject

class CompleteOnboardingUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke() {
        preferencesRepository.setOnboardingCompleted()
    }
}