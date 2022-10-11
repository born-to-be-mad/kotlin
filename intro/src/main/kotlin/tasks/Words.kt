package by.dma.tasks

import by.dma.extensions.eq

/**
 * A member extension functions 'record' and 'unaryPlus' available only in the  class.
 *
 * @author dzmitry.marudau
 * @since 2022.10
 */
class Words {
    private val list = mutableListOf<String>()

    fun String.record() {
        list += this
    }

    operator fun String.unaryPlus() {
        //list += this
        record()
    }

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}


