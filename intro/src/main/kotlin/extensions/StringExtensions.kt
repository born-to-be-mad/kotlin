package by.dma.extensions

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */

//fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastChar(): Char = get(length - 1)

fun String.repeat(n: Int): String {
    val sb = StringBuilder(n * length)
    for (i in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}

infix fun String.eq(str: String) {
    if (this != str) throw AssertionError("$this != $str")
    else println("$this == $str: OK")
}