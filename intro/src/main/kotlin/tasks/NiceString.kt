package by.dma.tasks

/**
 * A string is nice if at least two of the following conditions are satisfied:<p>
 * 1.It doesn't contain substrings bu, ba or be;
 * 2.It contains at least three vowels (vowels are a, e, i, o and u);
 * 3.It contains a double letter (at least two similar letters following one another), like b in "abba".
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
fun String.isNice(): Boolean {
    val condition1 = setOf("bu", "ba", "be").none { this.contains(it) }

    val condition2 = count { it in setOf('a', 'e', 'i', 'o', 'u') } >= 3

    val condition3 = zipWithNext().any { it.first == it.second }
    // alternative solution
    //val condition3 = windowed(2).any { it[0] == it[1] }

    return setOf(condition1, condition2, condition3).count { it } >= 2
}