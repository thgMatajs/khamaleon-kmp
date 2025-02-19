package io.gentalha.code.khamaleon.colors.material.ktx

import io.gentalha.code.khamaleon.colors.Color
import io.gentalha.code.khamaleon.colors.contrast.Contrast
import io.gentalha.code.khamaleon.colors.dislike.DislikeAnalyzer
import io.gentalha.code.khamaleon.colors.material.model.BaseColor
import io.gentalha.code.khamaleon.colors.palettes.TonalPalette
import io.gentalha.code.khamaleon.colors.utils.ColorUtils

/**
 * Check if the color is light.
 *
 * @receiver[Color] to check.
 * @return [Boolean] true if the color is light, false otherwise.
 */
fun Color.isLight(): Boolean {
    return this != BaseColor.transparent && ColorUtils.calculateLuminance(argb.toInt()) > 0.5
}

/**
 * Lighten the color by the given ratio.
 *
 * @receiver[Color] to lighten.
 * @param[ratio] the ratio to lighten the color by.
 * @return [Color] The lightened color or the original color if the lightened color is not valid.
 */
fun Color.lighten(ratio: Float = 1.0f): Color {
    val hct = toHct()
    val tone = Contrast.lighter(hct.tone, ratio.toDouble()).takeIf { it > -1 }
    return if (tone == null) this else hct.withTone(tone).toColor()
}

/**
 * Darken the color by the given ratio.
 *
 * @receiver[Color] to darken.
 * @param[ratio] the ratio to darken the color by.
 * @return [Color] The darkened color or the original color if the darkened color is not valid.
 */
fun Color.darken(ratio: Float = 1.1f): Color {
    val hct = toHct()
    val tone = Contrast.darker(hct.tone, ratio.toDouble()).takeIf { it > -1 }
    return if (tone == null) this else hct.withTone(tone).toColor()
}

/**
 * Returns true if color is disliked.
 *
 * Disliked is defined as a dark yellow-green that is not neutral.
 *
 * @receiver The [Color] to check.
 * @return true if color is disliked
 */
fun Color.isDisliked(): Boolean {
    return DislikeAnalyzer.isDisliked(toHct())
}

/**
 * Format the integer as a hex string.
 *
 * @receiver[Int] to format.
 * @return [String] hex representation of the integer.
 */
internal fun Int.format(): String {
    return toString(16).padStart(2, '0')
}

/**
 * Convert the color to a [TonalPalette].
 *
 * @receiver[Color] to convert.
 * @return [TonalPalette] representation of the color.
 */
internal fun Color.toTonalPalette(): TonalPalette {
    return TonalPalette.from(this)
}

fun Color.toHex(): String {
    val hexChars = "0123456789ABCDEF"
    val colorInt = (alpha shl 24) or (red shl 16) or (green shl 8) or blue
    val hexString = StringBuilder("#")
    for (i in 7 downTo 0) {
        val index = (colorInt shr (i * 4)) and 0xF
        hexString.append(hexChars[index])
    }
    return hexString.toString()
}

fun Int.toColor(): Color {
    val longColor = this.toLong() and 0xFFFFFFFF
    return Color(colorRGBA = longColor)
}

fun String.isValidHexDecimalColor(): Boolean {
    val hexColorRegex = Regex("^#([A-Fa-f0-9]{6})$")
    return hexColorRegex.matches(this)
}