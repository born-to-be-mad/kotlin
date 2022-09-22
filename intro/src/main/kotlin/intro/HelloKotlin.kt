package by.dma.intro

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */

fun main() {
    println("Hello, Kotlin! No class required")
}

fun main(args: Array<String>) {
    // the result of if-expression stored into variable
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    // String templates in action
    println("Hello, $name! No class required")
}
