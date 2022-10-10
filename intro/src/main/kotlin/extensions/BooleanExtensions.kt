package by.dma.extensions


/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.10
 */
infix fun Boolean.eq(b: Boolean) {
    if (this != b) throw AssertionError("$this != $b")
    else println("$this == $b: OK")
}