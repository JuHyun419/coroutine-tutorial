package section5

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

/*
Hello,
isActive : true
isCancelled : false
isCompleted : false
Cancelled!
isActive : false
isCancelled : true
isCompleted : true
 */
fun main() = runBlocking {
    val job = launch {
        try {
            delay(1000L)
            println("World!")

            launch {
                println("Kotlin!")
            }
        } catch (e: CancellationException) {
            println("Cancelled!") // 5
        }
    }
    delay(500L)
    println("Hello,") // 1

    println("isActive : ${job.isActive}") // 2
    println("isCancelled : ${job.isCancelled}") // 3
    println("isCompleted : ${job.isCompleted}") // 4

    job.cancel()
    job.join()

    println("isActive : ${job.isActive}") // 6
    println("isCancelled : ${job.isCancelled}") // 7
    println("isCompleted : ${job.isCompleted}") // 8
}
