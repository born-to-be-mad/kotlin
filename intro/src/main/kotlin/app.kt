package by.dma

/**
 * Main application.
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */

fun main() {
    println("Start demo...")

    val string = readLine()
    val result = string?.let { Anagrams().count(it) }
    println(result)
}
