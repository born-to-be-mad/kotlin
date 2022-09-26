package by.dma.tasks

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var currentGuess = guess
    var currentSecret = secret
    var rightPosition = 0
    var wrongPosition = 0
    secret.forEachIndexed { index, c ->
        if (guess[index] == c) {
            rightPosition++
            currentGuess = currentGuess.replaceFirst(c.toString(), "")
            currentSecret = currentSecret.replaceFirst(c.toString(), "")
        }
    }
    currentSecret.forEachIndexed { index, c ->
        if (currentGuess.contains(c)) {
            wrongPosition++;
            currentGuess = currentGuess.replaceFirst(c.toString(), " ")
            currentSecret = currentSecret.replaceFirst(c.toString(), " ")
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}

fun evaluateGuessInFunctionalStyle(secret: String, guess: String): Evaluation {
    // count the number of right positions
    val rightPositions = secret.zip(guess).count {
        it.first == it.second
    }

    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count {
            it == ch
        }, guess.count {
            it == ch
        })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}