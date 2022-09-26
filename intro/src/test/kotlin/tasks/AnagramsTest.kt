package by.dma.tasks

import by.dma.tasks.Anagrams
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Test for Anagrams.
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
internal class AnagramsTest {
    val anagrams = Anagrams()

    @Test
    fun `given abba count returns 4`() {
        //baba, abab, baab, bbaa
        assertEquals(4, anagrams.count("abba"))
    }

    @Test
    fun `given ifailuhkqq count returns 3`() {
        //ifaqiluhkqq, ifailuhkqq, ifailuhkqq
        assertEquals(3, anagrams.count("ifailuhkqq"))
    }
}
