package com.example.task_manager.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Color Scheme Light (Claro)
private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = OnPrimaryColor,
    primaryContainer = PrimaryContainerColor,
    onPrimaryContainer = OnPrimaryContainerColor,

    secondary = SecondaryColor,
    onSecondary = OnSecondaryColor,
    secondaryContainer = SecondaryContainerColor,
    onSecondaryContainer = OnSecondaryContainerColor,

    tertiary = TertiaryColor,
    onTertiary = OnTertiaryColor,
    tertiaryContainer = TertiaryContainerColor,
    onTertiaryContainer = OnTertiaryContainerColor,

    error = ErrorColor,
    onError = OnErrorColor,
    errorContainer = ErrorContainerColor,
    onErrorContainer = OnErrorContainerColor,

    background = BackgroundColor,
    onBackground = OnBackgroundColor,

    surface = SurfaceColor,
    onSurface = OnSurfaceColor,

    outline = OutlineColor,
    outlineVariant = OutlineVariantColor,
    scrim = ScrimColor
)

// Color Scheme Dark (Oscuro)
private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryColor,
    onPrimary = PrimaryColor,
    primaryContainer = PrimaryColor,
    onPrimaryContainer = DarkPrimaryColor,

    secondary = DarkSecondaryColor,
    onSecondary = SecondaryColor,
    secondaryContainer = SecondaryColor,
    onSecondaryContainer = DarkSecondaryColor,

    tertiary = DarkTertiaryColor,
    onTertiary = TertiaryColor,
    tertiaryContainer = TertiaryColor,
    onTertiaryContainer = DarkTertiaryColor,

    error = ErrorColor,
    onError = OnErrorColor,
    errorContainer = ErrorContainerColor,
    onErrorContainer = OnErrorContainerColor,

    background = DarkBackgroundColor,
    onBackground = DarkOnSurfaceColor,

    surface = DarkSurfaceColor,
    onSurface = DarkOnSurfaceColor,

    outline = OutlineVariantColor,
    outlineVariant = OutlineColor,
    scrim = ScrimColor
)

@Composable
fun TaskManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}