package com.example.task_manager.application.usecase.settings

import com.example.task_manager.domain.repository.PreferencesRepository
import javax.inject.Inject

class SetThemeModeUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(mode: Int) {
        preferencesRepository.setThemeMode(mode)
    }
}