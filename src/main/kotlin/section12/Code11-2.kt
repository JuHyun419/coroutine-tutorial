package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

var count2 = 0
val mutex: Mutex = Mutex()

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    withContext(Dispatchers.Default) {
        repeat(10_000_000) {
            launch {
                mutex.withLock {
                    count2 += 1
                }
            }
        }
    }
    println("count = $count2")
    println("실행 시간 ::: ${getElapsedTime(startTime)}") // 6707ms
}

fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"
