package io.gentalha.code.khamaleon.android.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import io.gentalha.code.khamaleon.colors.dynamiccolor.DynamicColor

fun DynamicColor.toColor(): Color = Color(this.getArgb())

fun Color.isDark(): Boolean {
    return this.luminance() < 0.5
}