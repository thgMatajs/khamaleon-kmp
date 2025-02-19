package io.gentalha.code.khamaleon.colors.material.ktx

import io.gentalha.code.khamaleon.colors.Color
import io.gentalha.code.khamaleon.colors.material.Contrast
import io.gentalha.code.khamaleon.colors.material.PaletteStyle
import io.gentalha.code.khamaleon.colors.material.asVariant
import io.gentalha.code.khamaleon.colors.scheme.DynamicScheme
import io.gentalha.code.khamaleon.colors.scheme.SchemeContent
import io.gentalha.code.khamaleon.colors.scheme.SchemeExpressive
import io.gentalha.code.khamaleon.colors.scheme.SchemeFidelity
import io.gentalha.code.khamaleon.colors.scheme.SchemeFruitSalad
import io.gentalha.code.khamaleon.colors.scheme.SchemeMonochrome
import io.gentalha.code.khamaleon.colors.scheme.SchemeNeutral
import io.gentalha.code.khamaleon.colors.scheme.SchemeRainbow
import io.gentalha.code.khamaleon.colors.scheme.SchemeTonalSpot
import io.gentalha.code.khamaleon.colors.scheme.SchemeVibrant

/**
 * Generate a [DynamicScheme] based on the given [Color].
 *
 * @param[isDark] Whether the scheme should be dark or light.
 * @param[style] The style of the scheme, see [PaletteStyle].
 * @param[contrastLevel] The contrast level of the scheme.
 * @return The generated [DynamicScheme].
 */
internal fun Color.toDynamicScheme(
    isDark: Boolean,
    style: PaletteStyle,
    contrastLevel: Double = Contrast.Default.value,
): DynamicScheme {
    val hct = toHct()
    return when (style) {
        PaletteStyle.TonalSpot -> SchemeTonalSpot(hct, isDark, contrastLevel)
        PaletteStyle.Neutral -> SchemeNeutral(hct, isDark, contrastLevel)
        PaletteStyle.Vibrant -> SchemeVibrant(hct, isDark, contrastLevel)
        PaletteStyle.Expressive -> SchemeExpressive(hct, isDark, contrastLevel)
        PaletteStyle.Rainbow -> SchemeRainbow(hct, isDark, contrastLevel)
        PaletteStyle.FruitSalad -> SchemeFruitSalad(hct, isDark, contrastLevel)
        PaletteStyle.Monochrome -> SchemeMonochrome(hct, isDark, contrastLevel)
        PaletteStyle.Fidelity -> SchemeFidelity(hct, isDark, contrastLevel)
        PaletteStyle.Content -> SchemeContent(hct, isDark, contrastLevel)
    }
}

/**
 * Create a [DynamicScheme] based on the provided colors.
 *
 * If a color is not provided, then the color palette will be generated from the [style] and [seedColor].
 *
 * @param[seedColor] The color to base the scheme on.
 * @param[isDark] Whether the scheme should be dark or light.
 * @param[primary] The primary color of the scheme.
 * @param[secondary] The secondary color of the scheme.
 * @param[tertiary] The tertiary color of the scheme.
 * @param[neutral] The neutral color of the scheme.
 * @param[neutralVariant] The neutral variant color of the scheme.
 * @param[error] The error color of the scheme.
 * @param[style] The style of the scheme.
 * @param[contrastLevel] The contrast level of the scheme.
 */
internal fun DynamicScheme(
    seedColor: Color,
    isDark: Boolean,
    primary: Color? = null,
    secondary: Color? = null,
    tertiary: Color? = null,
    neutral: Color? = null,
    neutralVariant: Color? = null,
    error: Color? = null,
    style: PaletteStyle = PaletteStyle.Fidelity,
    contrastLevel: Double = Contrast.Default.value,
): DynamicScheme {
    val defaults = seedColor.toDynamicScheme(isDark, style, contrastLevel)

    return DynamicScheme(
        sourceColorHct = seedColor.toHct(),
        variant = style.asVariant,
        isDark = isDark,
        contrastLevel = contrastLevel,
        primaryPalette = primary?.toTonalPalette() ?: defaults.primaryPalette,
        secondaryPalette = secondary?.toTonalPalette() ?: defaults.secondaryPalette,
        tertiaryPalette = tertiary?.toTonalPalette() ?: defaults.tertiaryPalette,
        neutralPalette = neutral?.toTonalPalette() ?: defaults.neutralPalette,
        neutralVariantPalette = neutralVariant?.toTonalPalette() ?: defaults.neutralVariantPalette,
        errorPalette = error?.toTonalPalette() ?: defaults.errorPalette,
    )
}