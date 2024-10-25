package section4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Hello World!
launch A Start
launch B Start
launch A End
launch B End
 */
fun main() = runBlocking<Unit> {
    launch {
        println("launch A Start")
        delay(1000L) // 1초 동안 코루틴 일시정지
        println("launch A End")
    }
    launch {
        println("launch B Start")
        delay(1000L) // 1초 동안 코루틴 일시정지
        println("launch B End")
    }
    println("Hello World!")
}
