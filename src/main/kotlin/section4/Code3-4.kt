package section4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val imageProcessingDispatcher = Dispatchers.Default.limitedParallelism(2)
    repeat(1000) {
        launch(imageProcessingDispatcher) {
            Thread.sleep(100L) // 이미지 처리 작업
            println("[${Thread.currentThread().name}] 이미지 처리 완료")
        }
    }
}
