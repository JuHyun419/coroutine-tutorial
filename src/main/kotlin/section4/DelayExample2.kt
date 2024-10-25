package section4

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Hello World!
launch A Start
launch A End
launch B Start
launch B End
 */
fun main() = runBlocking<Unit> {
    launch {
        println("launch A Start")
        println("launch A End")
    }
    launch {
        println("launch B Start")
        println("launch B End")
    }
    println("Hello World!")
}
