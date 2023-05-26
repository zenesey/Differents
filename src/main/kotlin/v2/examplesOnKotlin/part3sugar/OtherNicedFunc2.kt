package v2.examplesOnKotlin.part3sugar




fun main() {
    extensionFuncEx()
    typealiasEx()
    calculate(2, 4) {x, y -> x + y}
}
// fun1
data class Book(var str: String) {
    fun showOnConsole() {
        println(str)
    }
}
// Функция расширения для класса Book
fun Book.extensionFunc() {
    str = "changeStr"
}

fun extensionFuncEx() {
    var book = Book("a")
    book.extensionFunc()
    println(book.str)
}
// Возможность описывать операцию как лямбда
typealias Operation = (Int, Int) -> (Any)

fun typealiasEx() {
    var op1: Operation = { x, y -> x to y }
    var op2: Operation = { x, z -> x - z }
    var op3: Operation = { x, z -> x * z }
    resultFromTypeAlias(op1, 1, 8)
    resultFromTypeAlias(op2, 5, 98)
    resultFromTypeAlias(op3, 122, 2)
}

fun resultFromTypeAlias(op: Operation, firs: Int, second: Int) {
    println(op(firs, second))
}
// Встраиваемая функция
inline fun calculate(firs: Int, second: Int, noinline op: (Int, Int) -> Int): Int{
    return op(firs,second)
}