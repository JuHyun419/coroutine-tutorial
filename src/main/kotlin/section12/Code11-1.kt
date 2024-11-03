package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

var count = 0

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    withContext(Dispatchers.Default) {
        repeat(10_000_000) {
            launch {
                count2 += 1
            }
        }
    }
    println("count = $count2")
    println("실행 시간 ::: ${getElapsedTime(startTime)}") // 4481ms
}

