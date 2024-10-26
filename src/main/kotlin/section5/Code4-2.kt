package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) {repeatTime ->
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 반복횟수: $repeatTime")
        }
    }

    delay(2500L)

    // cancel 함수는 코루틴을 곧바로 취소하지 않고, 취소 확인용 플래그를 '취소 요청됨'으로 바꾸는 역할만 한다.
    // 이후 미래에 취소 확인 플래그가 확인되는 시점에 코루틴이 취소된다. -> 순차성 관점에서 중요한 문제
    longJob.cancel()
}

fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"
