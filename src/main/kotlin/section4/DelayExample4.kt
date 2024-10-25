package section4

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
launch A Start
launch A End
Hello World!
launch B Start
launch B End
 */
fun main() = runBlocking<Unit> {
    launch {
        println("launch A Start")
        println("launch A End")
    }

    delay(1000L) // 1초 동안 코루틴 일시정지

    launch {
        println("launch B Start")
        println("launch B End")
    }
    println("Hello World!")
}
