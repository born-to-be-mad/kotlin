package by.dma.tasks

/**
 * Implement the function that checks whether a string is a valid identifier.
 * A valid identifier is a non-empty string that starts with a letter or underscore and consists of
 * only letters, digits and underscores.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
fun isValidIdentifier(s: String): Boolean {
    // check if s contains only characters
    val isUderscoreOrSymbol = fun(c: Char) = c in 'a'..'z' || c in 'A'..'Z' || c == '_'
    val isSupportedSymbol = fun(c: Char) = c in '0'..'9' || c in 'a'..'z' || c in 'A'..'Z' || c == '_'
    return s.isNotEmpty()
            && isUderscoreOrSymbol(s.get(0))
            && s.all { isSupportedSymbol(it) }
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}