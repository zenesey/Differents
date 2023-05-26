package v1.advanced

fun persistence(num: Int) = persistenceForExample(num)

fun persistenceForExample(arg: Int): Int {

    return divideUntilLessThanTen(arg, 0)
}

fun divideUntilLessThanTen(number: Int, count: Int): Int {
    if (number < 10) return count
    else {
        var divResult = 1
        var divisor = number
        while (divisor > 0) {
            divResult *= divisor % 10
            divisor /= 10
        }
        return divideUntilLessThanTen(divResult, count + 1)
    }
}


//4 --> 0 (because 4 is already a one-digit number)
//999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
//39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
fun main() {
    println("987 / 10  = ${987 / 10}")
    println("987 / 100 = ${987 / 100}")
    println("987 % 10  = ${987 % 10}")
    println("987 % 100 = ${987 % 100}")
    println()
    println("98 / 10   = ${98 / 10}")
    println("98 / 100  = ${98 / 100}")
    println("98 % 10   = ${98 % 10}")
    println("98 % 100  = ${98 % 100}")
    println()
    println("987 / 10  = ${987 / 10}")// 98
    println("987 % 10  = ${987 % 10}")// 7

    println(persistenceForExample(999))

}
