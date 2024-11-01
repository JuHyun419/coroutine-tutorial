package section9

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 로깅] ::: $throwable")
    }

    CoroutineScope(Dispatchers.IO)
        .launch(CoroutineName("Coroutine1") + exceptionHandler) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2에 예외가 발생했습니다")
            }
            launch(CoroutineName("Coroutine3")) {
                // 다른 작업
            }
        }

    delay(1000L)
}
