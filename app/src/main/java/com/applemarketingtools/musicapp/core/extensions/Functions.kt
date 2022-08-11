package com.applemarketingtools.musicapp.core.extensions

inline fun <T> tryOrNull(from: String? = null, action: () -> T?): T? {
    return try {
        action.invoke()
    } catch (t: Throwable) {
        val s = if (from == null) "tryOrNull" else "tryOrNull from: $from"
        e(t) { s }
        null
    }
}

