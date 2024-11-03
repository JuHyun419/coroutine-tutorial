package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

var count3 = 0
val countChangeDispatcher = newSingleThreadContext("전용 스레드")

fun main() = runBlocking<Unit> {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch(countChangeDispatcher) {
                count3 += 1
            }
        }
    }

    println("count = $count3")
}
