package section8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {
    val newScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)
    newScope.launch(context = CoroutineName("LaunchCoroutine")) {
        println("newScope의 coroutineContext: ${newScope.coroutineContext}")
        println("launch 코루틴의 coroutineContext: ${this.coroutineContext}")
        println("launch 코루틴의 parentJob: ${this.coroutineContext[Job]?.parent}")
    }
    Thread.sleep(1000L)
}
