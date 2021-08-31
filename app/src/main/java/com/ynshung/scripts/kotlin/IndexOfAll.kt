package com.ynshung.scripts.kotlin

// Search for an element in a list and return a list of indexes of the element that's in the list

fun <T> List<T>.indexOfAll(element: T): List<Int> {
    val list = mutableListOf<Int>()
    this.forEachIndexed { index, t ->
        if (element == t) {
            list.add(index)
        }
    }
    return list
}