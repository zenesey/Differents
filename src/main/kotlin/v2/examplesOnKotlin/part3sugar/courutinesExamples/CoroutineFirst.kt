package v2.examplesOnKotlin.part3sugar.courutinesExamples

import kotlinx.coroutines.*
import java.util.Random

fun main() {
//    coroutineFirst()
//    coroutineSecond()
    coroutineThird()
}
// 1 rubBlocking ток мейн или тесты
// 2 launch возвращает JOB, запуск корутины, выполняються кто как успеет, возвращает только job которым можно
// управлять, порядок не соблюдаеться

// 3 async возвращает Deferred, Можно сделать lazy, возращает значение, порядок соблюдаеться
// 4 await жди пока выполниться
// 5 cancel остановка корутины

fun coroutineFirst() = runBlocking {
    println("start")
    repeat(100) {
        var a = launch {
            var result = forCoroutine("alex + $it")
            println(result)
        }
    }
    println("finish")

}
fun coroutineSecond() = runBlocking {
    println("start")
    var coroutine = List(100) {
        async (start = CoroutineStart.LAZY) {
          forCoroutine("alex + $it")
        }
    }
    coroutine.forEach{ println(it.await()) }
    println("finish")
}



suspend fun forCoroutine(name: String): String {
    delay(Random().nextLong(5000))
    return "name is $name"
}