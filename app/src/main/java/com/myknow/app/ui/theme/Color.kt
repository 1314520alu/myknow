package com.myknow.app.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Ink = Color(0xFF0B1220)
val InkRaised = Color(0xFF121C2C)
val InkHigh = Color(0xFF1A2740)
val Sand = Color(0xFFE8A838)
val Foam = Color(0xFF4ECDC4)
val Cloud = Color(0xFFE8EEF4)
val Mist = Color(0xFF9AA4B2)
val Danger = Color(0xFFFF6B6B)

val MyKnowColors = darkColorScheme(
    primary = Sand,
    onPrimary = Color(0xFF1A1204),
    primaryContainer = Color(0xFF3D2E12),
    onPrimaryContainer = Color(0xFFFFE2A8),
    secondary = Foam,
    onSecondary = Color(0xFF04221F),
    secondaryContainer = Color(0xFF16443F),
    onSecondaryContainer = Color(0xFFB7F3EE),
    tertiary = Color(0xFF5B8CFF),
    background = Ink,
    onBackground = Cloud,
    surface = InkRaised,
    onSurface = Cloud,
    surfaceVariant = InkHigh,
    onSurfaceVariant = Mist,
    outline = Color(0xFF3A4A63),
    error = Danger,
    onError = Color.White,
)

val MyKnowTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        lineHeight = 36.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 30.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        letterSpacing = 0.2.sp,
    ),
)
