package sometests

import v1.advanced.persistence
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PersistenceTest {

    @Test
    fun `Basic Tests`() {

//        assertEquals(3, persistence(39))
        //39 3 * 9 = 27, 2 * 7 = 14, 1 * 4 = 4,
        assertEquals(0, persistence(4))
        assertEquals(2, persistence(25))

        assertEquals(4, persistence(999))
    }
}
