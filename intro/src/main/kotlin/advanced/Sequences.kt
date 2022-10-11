package by.dma.advanced

import kotlin.random.Random

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.10
 */
fun main() {
    val sequence1 = generateSequence { Random.nextInt() }
    val sequence2 = generateSequence { Random.nextInt(10).takeIf { it > 0 } }
    val sequence3 = generateSequence(0) { it + 2 }
    val sequence4 = sequence {
        var x = 100;
        while (true) {
            yield(x--)
        }
    }
    println("sequence1: " + sequence1.take(5).toList())
    println("sequence2: " + sequence2.take(5).toList())
    println("sequence3: " + sequence3.take(5).toList())
    println("sequence4: " + sequence4.take(5).toList())
}
