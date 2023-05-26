package v2.examplesOnJava.feature



import v2.examplesOnKotlin.part3sugar.funWhichCanBeCallEveryWhere
import kotlin.Exception

fun main() {
    RunCatchEx.runCatch(5)
    RunCatchEx.runCatch(-1)
}

object RunCatchEx{

    fun runCatch(arg1: Int) {
        // Блок кода который в случае exception мы получим null
        val someVal = runCatching {
            recurs(arg1)
        }
        println(someVal.getOrNull())
        funWhichCanBeCallEveryWhere()

    }

    private fun recurs(arg1: Int): Int {
        if (arg1 == -1) throw Exception()
        if (arg1 > 100) return arg1
        return recurs(arg1*10)
    }

    fun tryCatch() {
        try {

        }catch (e: Exception) {

        }finally {

        }
    }
}