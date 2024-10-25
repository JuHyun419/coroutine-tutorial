package section2

import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main() {
    val executorService = Executors.newFixedThreadPool(2)

    // ExecutorService 에 반환 값이 있는 작업 제출
    val future: Future<String> = executorService.submit<String> {
        Thread.sleep(2000)
        return@submit "result!"
    }

    // 반환값이 올때까지 메인 스레드 블로킹
    val result = future.get()
    println(result)

    executorService.shutdown()
}
