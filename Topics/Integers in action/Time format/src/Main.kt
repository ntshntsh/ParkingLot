fun main() {
    val totalSeconds = System.currentTimeMillis() / 1000 // do not change this line
    val time = totalSeconds % (24 * 60 * 60)
    val hour = 3600
    println("${time / hour}:${time % hour / 60}:${time % hour % 60}")
}