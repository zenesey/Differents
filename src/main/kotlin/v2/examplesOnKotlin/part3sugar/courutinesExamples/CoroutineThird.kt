package v2.examplesOnKotlin.part3sugar.courutinesExamples

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() {
//    coroutineThird()
//    coroutineFourth()
}

fun coroutineThird() = runBlocking {
    println("start")
    var channel = Channel<String>()

    var job = launch {
        println("launch")
        delay(2000)
        channel.send("job 1")
    }

    var def = async {
        println("async")
        channel.receive()
    }
    println("finish")
    job.join()
    println(def.await())
}

fun coroutineFourth() = runBlocking {
    println("start")
    var channel = Channel<List<String>>()

    var job = launch {
        var forSend = List(10) {
            async {
                forCoroutine("alex + $it from first coroutine")
            }
        }
        channel.send(forSend.awaitAll().onEach { println(it) })
    }
    println("after launch")

    var forReceive = async {
        channel.receive().map { it.replace("first", "second") }
    }

    println("after async")

    job.join()
    forReceive.await().forEach{ println(it) }

    delay(3000)
    println("finish")
}





