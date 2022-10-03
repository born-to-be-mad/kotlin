package by.dma.advanced

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.10
 */

interface List<E> {
    fun get(index: Int): E
    fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T>

        fun <T> List<T>.firstOrNull(): T?
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val filtered = list.filter { it % 2 == 0 }
    println(filtered)
    val firstOrNull = list.firstOrNull()
    println(firstOrNull)
}
