package com.example.task_manager.application.usecase.settings

import com.example.task_manager.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemeModeUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    operator fun invoke(): Flow<Int> = preferencesRepository.getThemeMode()
}