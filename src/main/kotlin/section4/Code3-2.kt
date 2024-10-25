package section4

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

val multiThreadDispatcher: CoroutineDispatcher = newFixedThreadPoolContext(2, "MultiThread")

fun main() = runBlocking<Unit> {
    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] Start")
    }

    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] Start")
    }

    launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] Start1")
    }

    launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] Start2")
    }

    launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] Start3")
    }
}
