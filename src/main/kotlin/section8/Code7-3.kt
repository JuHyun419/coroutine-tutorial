package section8

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import section5.getElapsedTime

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val parentJob = launch(Dispatchers.IO) { // 부모 코루틴 생성
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async { // 자식 코루틴 생성
                delay(1000L) // DB로부터 데이터를 가져오는데 걸리는 시간
                println("${it}로부터 데이터를 가져오는데 성공했습니다")
                return@async "[${it}]data"
            }
        }
        val dbResults: List<String> = dbResultsDeferred.awaitAll() // 모든 코루틴이 완료될 때까지 대기

        println(dbResults) // 화면에 표시
        println(getElapsedTime(startTime))
    }

    parentJob.cancel()
}
