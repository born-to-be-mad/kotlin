package by.dma

/**
 * Best Practices in Kotlin.
 * Inspired by the talk "Idiomatic Kotlin, Anton Arhipov" 2022
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
// EXTENSIONS
// Use Extensions without companion objects
// Classes are needed for modeling
// Use extension functions liberally
// Restrict the visibility to minimize APi polution
// Use local extension functions, member extension functions, and top-level extension functions
fun String.isPhoneNumber(s: String) = length == 11 && all { it.isDigit() }

// Spring + Kotlin
// Spring has a lot of extension functions
// SAM convention, Trailing lambda parameter, varargs can improve the readability of the code

// Scope functions: they are all implemented as extension functions
// Function selection: let, run, with, apply, also
// Do not overuse scope functions

// NAMED VARIABLES & DEFAULT VALUES FOR PARAMETERS
// Default argument values diminish the need for overloading
// Named parameters is a necessary tool for working with default argument values

// EXPRESSIONS
// For public API, keep return type in the signature
// For private API it is generally ok to omit the return type
//Use `when` as expression body
abstract class Weather
class Sunny : Weather()
class Rainy : Weather()

fun adjustSpeed(weather: Weather) = when (weather) {
    is Sunny -> 100
    is Rainy -> 50
    else -> {
        println("Unknown weather")
        0
    }
}

// NULL-safety
// Use the safe call operator
// Avoid not-null assertions!! Use `lateinit`
// Use elvis operator
// Consider using safe cast for type checking
// Use range checks instead of comparison pairs
// Ranges can be used in the loops
class Person(val name: String?, val age: Int?)

class Nullable {
    fun someFunction() = { }
}

fun createNullable(): Nullable? = null

fun isLatinUppercase(c: Char) = c in 'A'..'Z'


