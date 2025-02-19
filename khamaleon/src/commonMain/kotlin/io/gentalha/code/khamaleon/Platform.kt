package io.gentalha.code.khamaleon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform