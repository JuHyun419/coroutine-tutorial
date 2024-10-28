package section6

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis() // 1. 시작 시간 기록

    // 2. 플랫폼1에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("철수", "영수")
    }

    // 3. 플랫폼2에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("영희")
    }

    // 4. 두 개의 코루틴으로부터 결과가 수신될 때까지 대기
    val results = awaitAll(participantDeferred1, participantDeferred2)

    // 5. 지난 시간 표시 및 참여자 목록을 병합해 출력
    println("[${getElapsedTime3(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])}")
}

private fun getElapsedTime3(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"