@file:JvmName("Utils")

package by.dma.extensions

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */

fun List<Int>.sum(): Int {
    var sum = 0
    for (element in this) {
        sum += element
    }
    return sum
}
