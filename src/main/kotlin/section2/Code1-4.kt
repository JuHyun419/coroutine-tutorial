package section2

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    val executorService = Executors.newFixedThreadPool(2)

    // ExecutorService 에 반환 값이 있는 작업 제출
    val completableFuture = CompletableFuture.supplyAsync(
        {
            Thread.sleep(2000L)
            return@supplyAsync "더미 결과값"
        },
        executorService
    )

    // 콜백 형식으로 결과값 처리
    completableFuture.thenAccept { result ->
        println("결과:${result}")
    }

    executorService.shutdown()
}
