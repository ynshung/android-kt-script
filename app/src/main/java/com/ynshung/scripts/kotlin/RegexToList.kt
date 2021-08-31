package com.ynshung.scripts.kotlin

// A function that returns lists of string searched in the specified original string and search pattern

fun regexToList(pattern: String, str: String): List<String> {
    return Regex(pattern)
        .findAll(str)
        .map { it.groupValues[1] }
        .toList()
}