package v2.examplesOnKotlin.part3sugar.courutinesExamples

import kotlinx.coroutines.*
import java.util.*
import kotlin.math.log
import kotlin.system.measureTimeMillis






fun main() {

    CoroutineScope(Dispatchers.Default).launch {
    }
    var myThread = newSingleThreadContext("my little thread")

    var myScope = CoroutineScope(myThread).launch {
    }

    runBlocking {
        coroutine2()
    }

    GlobalScope.launch {
        isActive
    }
}













/*
Dispatchers
main
default в дефолтном диспечер
io для ввода вывода по умолчанию либо 64 либо колво ядер в зависимости чего больше делит их с default
unconfined запускает в основно потоке до момента приастоновки далее в любом другом потоке
newsingleThreadContext просто новый созданный контекс
 */

suspend fun coroutine2() {

    println("start")
    coroutineScope {
        launch {
            println("launch 1")
            forCoroutine2("alex 1")
        }
        val job2 = launch(start = CoroutineStart.LAZY) {
            println("launch 2")
            forCoroutine2("alex 2")
        }
        val job3 = launch() {
            println("launch 3")
            delay(2000)
            forCoroutine2("alex 3")
        }
        measureTimeMillis {  }
        launch(Dispatchers.Default) {
            println("launch 4")
            forCoroutine2("alex 4")
            job2.start()
            job3.cancel("func was canceled")

        }
    }
    println("finish")
}

suspend fun forCoroutine2(name: String) {
    delay(Random().nextLong(5000))
    println("name is $name")
}