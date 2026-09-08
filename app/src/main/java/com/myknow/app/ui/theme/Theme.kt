package com.myknow.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyKnowTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MyKnowColors,
        typography = MyKnowTypography,
        content = content,
    )
}
