@file:JvmName("Utils")
package by.dma.extensions

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
class Extensions {

    fun max(a: Int, b: Int): Int = if (a > b) a else b

    fun min(a: Int, b: Int): Int = if (a < b) a else b

    fun displaySeparator(character: Char = '#', times: Int = 10) {
        repeat(times) {
            print(character)
        }
        println()
    }

    fun isNotDigit(c: Char) = c !in '0'..'9'
}