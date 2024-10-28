package section6

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L) // 네트워크 요청
        return@async "Dummy Response" // Dummy Response 반환
    }
    val result = networkDeferred.await() // 결과값이 반환될 때까지 runBlocking 일시 중단
    println(result) // 결과값 출력
}
