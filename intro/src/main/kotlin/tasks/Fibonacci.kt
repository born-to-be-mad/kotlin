package by.dma.tasks

import by.dma.extensions.eq

/**
 * Builds a sequence of Fibonacci numbers using 'sequence' function and 'yield'.
 *
 * @author dzmitry.marudau
 * @since 2022.10
 */
fun fibonacci(): Sequence<Int> = sequence {
    var left = 0
    var right = 1
    while (true) {
        val current = left
        yield(current)
        left = right
        right += current
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}