package v2.examplesOnKotlin.part3sugar.notSure

fun main() {
    var df = DifferentFunc()
    val s = intArrayOf(1, 2, 2, 2, 33)
    val list = intArrayOf(*s, 1, 2, 3, 4, 5)

    var ss = arrayListOf(2,5).toIntArray()

    df.varagExample(2,3,75, *list)

//
//    println(df.function1("func1", 1))
//    println(df.function2("func2", 2))
//
//    var unit = df.function3()
//    println(unit)
//
//    println(df.function4("func4", 4))
//    println(df.function4("func4", 4, "var3"))
//
//    println(df.function5("func5"))
//
//    println(df.function6(1, 2, 3, *list))
}

class DifferentFunc {

    //fun nameFun(args) : returnType
    fun classicMethod(arg1: String, arg2: Int): String {
        return arg1 + arg2
    }

    // Если метод однострочный то существует более короткое написание
    fun anotherWritingMethod(arg1: String, arg2: Int) = arg1 + arg2

    // Если метод ничего не возвращает то просто ничего за аргументами писать не нужно(почти аналог Void)
    fun anotherReturnTypeNothing() {
        println("fun3")
    }

    // Существует возможность присваивать аргументы по умолчанию
    fun defaultArgsValue(var1: String, var2: Int, var3: String = "defaultString") {

        defaultArgsValue("var1", 1)
        defaultArgsValue("var1", 1, "var3")
        // str + " " + str
        println("hello, var1 = $var1, and var2 + 3 = ${var2 + 3}")
    }

    // Также можно принебречь порядком аргументов
    fun argsOutOfOrder(arg1: String) = defaultArgsValue(var3 = arg1, var2 = 2, var1 = "someText")

    fun varagExample(vararg arg1: Int) {
        arg1.forEach { println(it) }

    }
}

