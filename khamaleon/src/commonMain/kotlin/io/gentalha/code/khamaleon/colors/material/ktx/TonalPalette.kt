package io.gentalha.code.khamaleon.colors.material.ktx

import io.gentalha.code.khamaleon.colors.Color
import io.gentalha.code.khamaleon.colors.hct.Hct
import io.gentalha.code.khamaleon.colors.palettes.TonalPalette


/**
 * Generates a [TonalPalette] from the given [color].
 *
 * @param[color] The color to generate the [TonalPalette] from.
 * @return The generated [TonalPalette].
 */
internal fun TonalPalette.Companion.from(color: Color): TonalPalette {
    return from(color.toHct())
}

/**
 * Generates a [TonalPalette] from the given [argb] color int.
 *
 * @param[argb] The ARGB representation of a color to generate the [TonalPalette] from.
 * @return The generated [TonalPalette].
 */
internal fun TonalPalette.Companion.from(argb: Int): TonalPalette {
    return fromInt(argb)
}

/**
 * Generates a [TonalPalette] from the given [Hct].
 *
 * @param[hct] The color to generate the [TonalPalette] from.
 * @return The generated [TonalPalette].
 */
internal fun TonalPalette.Companion.from(hct: Hct): TonalPalette {
    return fromHct(hct)
}