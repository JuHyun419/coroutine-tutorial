package section7

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    val coroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO
    val nameFromContext = coroutineContext[CoroutineName.Key]
    println(nameFromContext)

    val dispatcherFromContext = coroutineContext[CoroutineDispatcher]
    println(dispatcherFromContext)
}
