package v2.examplesOnKotlin.part3sugar.courutinesExamples

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime


fun main() {
    runBlocking {
        synchronizeEx()
    }
}

suspend fun synchronizeEx() {
    var counter = 0
    var counterForMutex = 0
    var counterForThread = 0
    val atomicCounter = AtomicInteger()
    val mutex = Mutex()

    val mySingleThread = newSingleThreadContext("my-single-thread")

    val timeOfClassic = measureTimeMillis {
        withContext(Dispatchers.Default) {
            repeat(10) {
                launch {
                    repeat(1000) {
                        counter++
                    }
                }
            }
        }
    }
    val timeOfAtomic = measureTimeMillis {
        withContext(Dispatchers.Default) {
            repeat(10) {
                launch {
                    repeat(1000) {
                        atomicCounter.incrementAndGet()
                    }
                }
            }
        }
    }

    val timeOfMutex = measureTimeMillis {
        withContext(Dispatchers.Default) {
            repeat(10) {
                launch {
                    repeat(1000) {
                        mutex.withLock {
                            counterForMutex++
                        }
                    }
                }
            }
        }
    }
    val timeOfMySingleThread = measureTimeMillis {
        withContext(mySingleThread) {
            repeat(10) {
                launch {
                    repeat(1000) {
                        counterForThread++
                    }
                }
            }
        }
    }

    println("Classic = $counter, atomic = $atomicCounter, mutex = $counterForMutex, thread = $counterForThread")
    println("Classic = $timeOfClassic, atomic = $timeOfAtomic, mutex = $timeOfMutex, thread = $timeOfMySingleThread")
}
