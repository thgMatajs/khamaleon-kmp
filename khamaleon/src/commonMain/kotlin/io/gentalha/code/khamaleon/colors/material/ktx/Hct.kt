package io.gentalha.code.khamaleon.colors.material.ktx

import io.gentalha.code.khamaleon.colors.Color
import io.gentalha.code.khamaleon.colors.hct.Hct
import io.gentalha.code.khamaleon.colors.hct.Hct.Companion.fromInt


/**
 * Convert HCT to a Compose [Color].
 *
 * @receiver The HCT to convert.
 * @return The Compose [Color] representation of the HCT.
 */
internal fun Hct.toColor(): Color {
    return toInt().toColor()
}



/**
 * Convert a Compose [Color] to [Hct].
 *
 * @receiver The color to convert.
 * @return The HCT representation of the color.
 */
internal fun Color.toHct(): Hct {
    return fromInt(this.argb.toInt())
}