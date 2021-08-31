package com.ynshung.scripts.kotlin

// Remove any whitespace in a string

fun String.strip(): String {
    return this.replace(" ", "")
}

// Remove substring from a string

fun String.remove(removeStr: String): String {
    return this.replace(removeStr, "")
}