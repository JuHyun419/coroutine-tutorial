package section4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    // 부모 코루틴
    launch(Dispatchers.IO) {

        // 자식 코루틴 -> 부모 코루틴에 설정된 CoroutineDispatcher 을 사용
        launch {
            println("[${Thread.currentThread().name}] Start1")
        }

        launch {
            println("[${Thread.currentThread().name}] Start2")
        }

        launch {
            println("[${Thread.currentThread().name}] Start3")
        }
    }
}
