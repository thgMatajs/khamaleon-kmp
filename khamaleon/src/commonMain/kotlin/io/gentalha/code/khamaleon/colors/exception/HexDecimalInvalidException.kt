package io.gentalha.code.khamaleon.colors.exception

class HexDecimalInvalidException : Exception() {
    override val message: String
        get() = "Hexadecimal inválido, por favor insira um valor válido. Exemplo: #FFFFFF"
}