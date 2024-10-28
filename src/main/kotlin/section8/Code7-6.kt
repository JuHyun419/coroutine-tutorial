package section8

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    launch {
        delay(1000L)
        println("[${Thread.currentThread().name}] launch 코루틴 종료 ::: ${getElapsedTime(startTime)}")
    }
    delay(2000L)
    println("[${Thread.currentThread().name}] runBlocking 코루틴 종료 ::: ${getElapsedTime(startTime)}")
}

private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"
