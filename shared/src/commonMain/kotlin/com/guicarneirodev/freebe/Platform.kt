package com.guicarneirodev.freebe

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform