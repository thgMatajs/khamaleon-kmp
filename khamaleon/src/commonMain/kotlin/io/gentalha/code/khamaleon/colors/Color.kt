package io.gentalha.code.khamaleon.colors

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
) {
    @Suppress("MagicNumber")
    val rgba: Long = alpha.toLong() or
            blue.toLong().shl(8) or
            green.toLong().shl(16) or
            red.toLong().shl(24)

    @Suppress("MagicNumber")
    val argb: Long = blue.toLong() or
            green.toLong().shl(8) or
            red.toLong().shl(16) or
            alpha.toLong().shl(24)

    @Suppress("MagicNumber")
    constructor(colorRGBA: Long) : this(
        red = (colorRGBA.shr(24) and 0xFF).toInt(),
        green = (colorRGBA.shr(16) and 0xFF).toInt(),
        blue = (colorRGBA.shr(8) and 0xFF).toInt(),
        alpha = (colorRGBA.shr(0) and 0xFF).toInt()
    )

    companion object
}

@Suppress("MagicNumber")
fun Color.Companion.parseColor(colorHEX: String): Color {
    if (colorHEX[0] != '#') throw IllegalArgumentException("Unknown color")
    var colorARGB = colorHEX.substring(1).toLong(16)
    if (colorHEX.length == 7) {
        colorARGB = colorARGB or 0x00000000ff000000
    } else if (colorHEX.length != 9) {
        throw IllegalArgumentException("Unknown color")
    }
    return Color(
        alpha = (colorARGB.shr(24) and 0xFF).toInt(),
        red = (colorARGB.shr(16) and 0xFF).toInt(),
        green = (colorARGB.shr(8) and 0xFF).toInt(),
        blue = (colorARGB.shr(0) and 0xFF).toInt(),
    )
}