package section2

fun main() {
    println("[${Thread.currentThread().name}] 시작")
    Thread.sleep(1000L) // Blocking
    println("[${Thread.currentThread().name}] 종료")
}
