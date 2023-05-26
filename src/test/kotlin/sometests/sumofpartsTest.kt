package sometests

import v1.advanced.sumParts
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test


class sumofpartsTest {
    fun dotest(ls: IntArray, expected: IntArray) {
        val actual: IntArray = sumParts(ls)
        assertArrayEquals(expected, actual)
    }
    @Test
    fun test() {
        dotest(intArrayOf(), intArrayOf(0));
        dotest(intArrayOf(0, 1, 3, 6, 10), intArrayOf(20, 20, 19, 16, 10, 0))
        dotest(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(21, 20, 18, 15, 11, 6, 0))
        dotest(intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358),
            intArrayOf(10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0))

    }
}