package tasks

import by.dma.tasks.isNice
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by IntelliJ IDEA.
 *
 * @author dzmitry.marudau
 * @since 2022.09
 */
internal class NiceStringKtTest {
    @Test
    fun `no conditions are satisfied`() {
        assertEquals(false, "bac".isNice())
    }

    @Test
    fun `only first condition is satisfied`() {
        assertEquals(false, "aza".isNice())
    }

    @Test
    fun `only second condition is satisfied`() {
        assertEquals(false, "abaca".isNice())
    }

    @Test
    fun `second and first conditions are satisfied`() {
        assertEquals(true, "baaa".isNice())
    }

    @Test
    fun `all three conditions are satisfied`() {
        assertEquals(true, "aaab".isNice())
    }
}

