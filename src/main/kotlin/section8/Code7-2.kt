package section8

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> { // 부모 코루틴
    val parentJob = coroutineContext[Job] // 부모 코루틴의 CoroutineContext로부터 부모 코루틴의 Job 추출
    launch { // 자식 코루틴
        val childJob = coroutineContext[Job] // 자식 코루틴의 CoroutineContext로부터 자식 코루틴의 Job 추출
        println("1. 자식 코루틴의 Job이 가지고 있는 parent는 부모 코루틴의 Job인가? ${childJob?.parent === parentJob}") // true
        println("2. 부모 코루틴의 Job은 자식 코루틴의 Job을 참조를 가지는가? ${parentJob?.children?.contains(childJob)}") // true
    }
}
