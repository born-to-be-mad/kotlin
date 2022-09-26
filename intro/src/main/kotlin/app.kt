package by.dma

import by.dma.tasks.Anagrams

/**
 * Main application.
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */

fun main() {
    println("Start demo...")
    println("Input the string to count the anagrams:")

    val string = readLine()
    val result = string?.let { Anagrams().count(it) }
    println(result)
}
