package tasks

import by.dma.tasks.Evaluation
import by.dma.tasks.evaluateGuess
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
    fun `example1`() {
        assertEquals(Evaluation(4, 0), evaluateGuess("ABCD", "ABCD"))
    }

    @Test
    fun `example2`() {
        assertEquals(Evaluation(0, 4), evaluateGuess("ABCD", "CDBA"))
    }

    @Test
    fun `example3`() {
        assertEquals(Evaluation(2, 2), evaluateGuess("ABCD", "ABDC"))
    }

    @Test
    fun `example4`() {
        assertEquals(Evaluation(1,0), evaluateGuess("AABC", "ADFE"))
    }

    @Test
    fun `example5`() {
        assertEquals(Evaluation(1, 1), evaluateGuess("AABC", "ADFA"))
    }

    @Test
    fun `example6`() {
        assertEquals(Evaluation(0, 2), evaluateGuess("AABC", "DFAA"))
    }

    @Test
    fun `example7`() {
        assertEquals(Evaluation(0, 1), evaluateGuess("AABC", "DEFA"))
    }

    @Test
    fun `example8`() {
        assertEquals(Evaluation(1, 0), evaluateGuess("DCFC", "ABEC"))
    }

    @Test
    fun `example9`() {
        assertEquals(Evaluation(1, 0), evaluateGuess("BDAD", "AAAE"))
    }
}