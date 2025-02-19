package io.gentalha.code.khamaleon.colors.material

import io.gentalha.code.khamaleon.colors.Color
import io.gentalha.code.khamaleon.colors.material.ktx.DynamicScheme
import io.gentalha.code.khamaleon.colors.scheme.DynamicScheme


/**
 * Create a custom [MaterialKolorsScheme] based on the provided colors.
 *
 * If a color is not provided, then the color palette will be generated from the [style] and [seedColor].
 *
 * @param[seedColor] The color to base the scheme on.
 * @param[isDark] Whether the scheme should be dark or light.
 * @param[isAmoled] Whether the dark scheme is used with Amoled screen (Pure dark).
 * @param[primary] The primary color of the scheme.
 * @param[secondary] The secondary color of the scheme.
 * @param[tertiary] The tertiary color of the scheme.
 * @param[neutral] The neutral color of the scheme.
 * @param[neutralVariant] The neutral variant color of the scheme.
 * @param[error] The error color of the scheme.
 * @param[style] The style of the scheme.
 * @param[contrastLevel] The contrast level of the scheme.
 * @param[isExtendedFidelity] Whether to use the extended fidelity color set. See [MaterialDynamicColors].
 * @param[modifyColorScheme] A lambda to modify the created [MaterialKolorsScheme].
 */
internal fun dynamicColorScheme(
    seedColor: Color,
    isDark: Boolean,
    isAmoled: Boolean,
    primary: Color? = null,
    secondary: Color? = null,
    tertiary: Color? = null,
    neutral: Color? = null,
    neutralVariant: Color? = null,
    error: Color? = null,
    style: PaletteStyle = PaletteStyle.Fidelity,
    contrastLevel: Double = Contrast.Default.value,
    isExtendedFidelity: Boolean = true,
    modifyColorScheme: ((MaterialKolorsScheme) -> MaterialKolorsScheme)? = null,
): MaterialKolorsScheme {
    val scheme = DynamicScheme(
        seedColor = seedColor,
        isDark = isDark,
        primary = primary,
        secondary = secondary,
        tertiary = tertiary,
        neutral = neutral,
        neutralVariant = neutralVariant,
        error = error,
        style = style,
        contrastLevel = contrastLevel,
    )

    return scheme.toColorScheme(isAmoled, isExtendedFidelity, modifyColorScheme)
}

/**
 * Create the actual [MaterialKolorsScheme] based on the given [DynamicScheme].
 */
internal fun DynamicScheme.toColorScheme(
    isAmoled: Boolean,
    isExtendedFidelity: Boolean = true,
    modifyColorScheme: ((MaterialKolorsScheme) -> MaterialKolorsScheme)? = null,
): MaterialKolorsScheme {
    val colors = MaterialKolorsScheme(scheme = this, isAmoled, isExtendedFidelity)
    return colors.let { modifyColorScheme?.invoke(it) ?: it }
}