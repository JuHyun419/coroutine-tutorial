package section9

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 발생] ::: $throwable")
    }
    val exceptionHandler2 = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 발생2] ::: $throwable")
    }

    CoroutineScope(exceptionHandler)
        .launch(CoroutineName("Coroutine1") + exceptionHandler2) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2에 예외가 발생했습니다")
            }
        }
    delay(1000L)
}
