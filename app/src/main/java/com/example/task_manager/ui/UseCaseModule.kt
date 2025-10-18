package com.example.task_manager.ui

import com.example.task_manager.application.usecase.notification.GetNotificationsEnabledUseCase
import com.example.task_manager.application.usecase.notification.SetNotificationsEnabledUseCase
import com.example.task_manager.application.usecase.preferences.CheckOnboardingCompletedUseCase
import com.example.task_manager.application.usecase.preferences.CompleteOnboardingUseCase
import com.example.task_manager.application.usecase.settings.GetThemeModeUseCase
import com.example.task_manager.application.usecase.settings.SetThemeModeUseCase
import com.example.task_manager.domain.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideCheckOnboardingCompletedUseCase(
        preferencesRepository: PreferencesRepository
    ): CheckOnboardingCompletedUseCase {
        return CheckOnboardingCompletedUseCase(preferencesRepository)
    }

    @Singleton
    @Provides
    fun provideCompleteOnboardingUseCase(
        preferencesRepository: PreferencesRepository
    ): CompleteOnboardingUseCase {
        return CompleteOnboardingUseCase(preferencesRepository)
    }

    @Singleton
    @Provides
    fun provideGetThemeModeUseCase(
        preferencesRepository: PreferencesRepository
    ): GetThemeModeUseCase {
        return GetThemeModeUseCase(preferencesRepository)
    }

    @Singleton
    @Provides
    fun provideSetThemeModeUseCase(
        preferencesRepository: PreferencesRepository
    ): SetThemeModeUseCase {
        return SetThemeModeUseCase(preferencesRepository)
    }

    @Singleton
    @Provides
    fun provideGetNotificationsEnabledUseCase(
        preferencesRepository: PreferencesRepository
    ): GetNotificationsEnabledUseCase {
        return GetNotificationsEnabledUseCase(preferencesRepository)
    }

    @Singleton
    @Provides
    fun provideSetNotificationsEnabledUseCase(
        preferencesRepository: PreferencesRepository
    ): SetNotificationsEnabledUseCase {
        return SetNotificationsEnabledUseCase(preferencesRepository)
    }
}