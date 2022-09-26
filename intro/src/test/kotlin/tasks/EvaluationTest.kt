package tasks

import by.dma.tasks.Evaluation
import by.dma.tasks.evaluateGuess
import by.dma.tasks.evaluateGuessInFunctionalStyle
import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
internal class EvaluationTest {
    @Test
    fun `check evaluateGuess`() {
        assertEquals(Evaluation(4, 0), evaluateGuess("ABCD", "ABCD"))
        assertEquals(Evaluation(0, 4), evaluateGuess("ABCD", "CDBA"))
        assertEquals(Evaluation(2, 2), evaluateGuess("ABCD", "ABDC"))
        assertEquals(Evaluation(1, 0), evaluateGuess("AABC", "ADFE"))
        assertEquals(Evaluation(1, 1), evaluateGuess("AABC", "ADFA"))
        assertEquals(Evaluation(0, 2), evaluateGuess("AABC", "DFAA"))
        assertEquals(Evaluation(0, 1), evaluateGuess("AABC", "DEFA"))
        assertEquals(Evaluation(1, 0), evaluateGuess("DCFC", "ABEC"))
        assertEquals(Evaluation(1, 0), evaluateGuess("BDAD", "AAAE"))
    }

    @Test
    fun `check evaluateGuessInFunctionalStyle`() {
        assertEquals(Evaluation(4, 0), evaluateGuessInFunctionalStyle("ABCD", "ABCD"))
        assertEquals(Evaluation(0, 4), evaluateGuessInFunctionalStyle("ABCD", "CDBA"))
        assertEquals(Evaluation(2, 2), evaluateGuessInFunctionalStyle("ABCD", "ABDC"))
        assertEquals(Evaluation(1, 0), evaluateGuessInFunctionalStyle("AABC", "ADFE"))
        assertEquals(Evaluation(1, 1), evaluateGuessInFunctionalStyle("AABC", "ADFA"))
        assertEquals(Evaluation(0, 2), evaluateGuessInFunctionalStyle("AABC", "DFAA"))
        assertEquals(Evaluation(0, 1), evaluateGuessInFunctionalStyle("AABC", "DEFA"))
        assertEquals(Evaluation(1, 0), evaluateGuessInFunctionalStyle("DCFC", "ABEC"))
        assertEquals(Evaluation(1, 0), evaluateGuessInFunctionalStyle("BDAD", "AAAE"))
    }
}