package io.gentalha.code.khamaleon.colors

import io.gentalha.code.khamaleon.colors.exception.HexDecimalInvalidException
import io.gentalha.code.khamaleon.colors.material.MaterialKolorsScheme
import io.gentalha.code.khamaleon.colors.material.PaletteStyle
import io.gentalha.code.khamaleon.colors.material.dynamicColorScheme
import io.gentalha.code.khamaleon.colors.material.ktx.isValidHexDecimalColor

fun getColors(
    colorHex: String,
    isDarkMode: Boolean,
    paletteStyle: PaletteStyle = PaletteStyle.Fidelity
): MaterialKolorsScheme {
    if (!colorHex.isValidHexDecimalColor()) {
        throw HexDecimalInvalidException()
    }
    return dynamicColorScheme(
        Color.parseColor(colorHex),
        isDarkMode,
        false,
        style = paletteStyle
    )
}

