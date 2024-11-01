package section10

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrint(keyword = "부모 코루틴이 실행 중입니다")
    launch {
        delayAndPrint(keyword = "자식 코루틴이 실행 중입니다")
    }
}

suspend fun delayAndPrint(keyword: String) {
    delay(1000L)
    println(keyword)
}
