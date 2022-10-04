package by.dma.tasks

import java.math.BigInteger

/**
Rational Numbers.
Your task is to implement a class Rational representing rational numbers. A rational number is a number expressed as a ratio n/d , where n (numerator) and d (denominator) are integer numbers, except that d cannot be zero. If the denominator is zero, you can throw an exception on creating a new instance of the class, e.g. IllegalArgumentException.

Examples of rational numbers are 1/2, 2/3, 117/1098, and 2/1 (which can alternatively be written simply as 2). Rational numbers are represented exactly, without rounding or approximation, which gives them the advantage compared to floating-point numbers.

Your task it to model the behavior of rational numbers, including allowing them to be added, subtracted, multiplied, divided and compared. All arithmetic and comparison operations must be available for rationals: +, -, *, /, ==, <, >= etc. Check whether a number belongs to a range should also be possible: 1/2 in 1/3..2/3 should return true.

The Rational class should contain a numerator and denominator which might be unlimited numbers, so use java.math.BigInteger class for storing them.

The rational numbers must be compared to their "normalized" forms: for example, 1/2 should be equal to 2/4, or 117/1098 to 13/122. The string representation of a rational must be also given in the normalized form. Note that the denominator 1 must be omitted, so 2/1 must be printed as "2". The denominator must be always positive in the normalized form. If the negative rational is normalized, then only the numerator can be negative, e.g. the normalized form of 1/-2 should be -1/2.

Note that you can use BigInteger.gcd to find the greatest common divisor used in the normalized form calculation.

You need to support two ways to create rationals. The first one is to convert a string representation to a rational directly, like in "1/2".toRational(). Converting an integer number should also be possible, and 1 should be used as denominator by default: "23".toRational() is the same as "23/1".toRational().

The alternative way to create a rational is to use divBy infix function like in 1 divBy 2. The receiver and the argument might be of types Int, Long, or BigInteger.
 */
// main class
class Rational(val numerator: BigInteger, val denominator: BigInteger) : Comparable<Rational> {

    init {
        require(denominator != BigInteger.ZERO) { "Denominator must not be zero" }
    }

    override
    fun toString(): String {
        val normalizedRational = normalize()
        return if (normalizedRational.denominator == BigInteger.ONE) {
            normalizedRational.numerator.toString()
        } else {
            "${normalizedRational.numerator}/${normalizedRational.denominator}"
        }
    }


    override fun equals(other: Any?): Boolean {
        val normalizedOriginal = this.normalize()
        val normalizedOther = (other as Rational).normalize()
        return normalizedOriginal.numerator == normalizedOther.numerator && normalizedOriginal.denominator == normalizedOther.denominator
    }

    operator fun plus(other: Rational): Rational {
        val newNumerator = numerator * other.denominator + other.numerator * denominator
        val newDenominator = denominator * other.denominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun minus(other: Rational): Rational {
        val newNumerator = numerator * other.denominator - other.numerator * denominator
        val newDenominator = denominator * other.denominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun times(other: Rational): Rational {
        val newNumerator = numerator * other.numerator
        val newDenominator = denominator * other.denominator
        return Rational(newNumerator, newDenominator)
    }

    operator fun div(other: Rational): Rational {
        val newNumerator = numerator * other.denominator
        val newDenominator = denominator * other.numerator
        return Rational(newNumerator, newDenominator)
    }

    operator fun unaryMinus(): Rational {
        return Rational(-numerator, denominator)
    }

    override
    fun compareTo(other: Rational): Int {
        val thisNumerator = numerator * other.denominator
        val otherNumerator = other.numerator * denominator
        return thisNumerator.compareTo(otherNumerator)
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}

// Extensions
fun String.toRational(): Rational {
    val strings = this.split("/")
    val numinator = strings.getOrElse(0) { "0" }
    val denominator = strings.getOrElse(1) { "1" }
    return Rational(
        numinator.toBigInteger(), denominator.toBigInteger()
    )
}

fun Rational.normalize(): Rational {
    val gcd = this.numerator.gcd(this.denominator)
    var newNumerator = this.numerator / gcd
    var newDenominator = this.denominator / gcd
    if (newDenominator < BigInteger.ZERO) {
        newNumerator = newNumerator.negate()
        newDenominator = newDenominator.negate()
    }
    return Rational(newNumerator, newDenominator)
}


infix fun Int.divBy(num: Int): Rational {
    return Rational(this.toBigInteger(), num.toBigInteger())
}

infix fun Long.divBy(num: Long): Rational {
    return Rational(this.toBigInteger(), num.toBigInteger())
}

infix fun BigInteger.divBy(num: BigInteger): Rational {
    return Rational(this, num)
}
