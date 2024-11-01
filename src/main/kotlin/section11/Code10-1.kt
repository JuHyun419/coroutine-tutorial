package section11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    launch {
        while(true) {
            print("A")
            yield() // 스레드 사용 권한 양보
        }
    }

    while(true) {
        print("B")
        yield() // 스레드 사용 권한 양보
    }
}
