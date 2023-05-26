package v1.advanced

// n = 5
// signature =  1, 1, 2

// 1 1 2
// 1 2 4
// 2 4 7
// 4 7 13
// 7 13 24

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray =
    generateSequence (Triple( signature[0], signature[1], signature[2]))
    { Triple( it.second, it.third, it.first + it.second + it.third) }
        .map { it.first }
        .take(n)
        .toList()
        .toDoubleArray()
