package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    var count = 0
    val whileJob: Job = launch(Dispatchers.Default) {
        while(this.isActive) { // Coroutine.isActive -> count: 85000
//        while(true) {
            count++
            println(count)
            // delay(1L) count: 80
            // yield() count: 48911
        }
    }
    delay(100L) // 100밀리초 대기
    whileJob.cancel() // 코루틴 취소
}
