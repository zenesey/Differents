package v1.advanced

fun sumParts(ls: IntArray): IntArray {
    if (ls.isEmpty()) IntArray(0)
    val newLs = ls.toMutableList()

    return generateSequence(newLs.sum()) {
        newLs.sum() - newLs.removeAt(0)
    }.take(ls.size + 1).toList().toIntArray()

}

fun sumParts2(ls: IntArray): IntArray {
    val result = IntArray(ls.size + 1)
    var sum = ls.sum()
    result[0] = sum

    for (i in 1..ls.size) {
        sum -= ls[i - 1]
        result[i] = sum
    }

    return result
}

fun sumParts3(ls: IntArray) =
    ls.foldRightIndexed(IntArray(ls.size + 1))
    { i, n, acc -> acc[i] = acc[i + 1] + n; acc }

//dotest(intArrayOf(0, 1, 3, 6, 10), intArrayOf(20, 20, 19, 16, 10, 0))