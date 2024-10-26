package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
//        Thread.sleep(1000L)
        delay(1000L)
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin() // longJob 취소 요청 후 취소 완료될 때까지 호출 코루틴 일시 중단
    executeAfterJobCancelled2() // 취소 후 실행돼야 하는 동작
}

fun executeAfterJobCancelled2() {
    println("longJob 코루틴 취소 후 실행돼야 하는 동작")
}
