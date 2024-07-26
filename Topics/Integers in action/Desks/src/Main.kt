const val CLASSES = 3

fun main() {
    val students = Array(CLASSES) { readLine()!!.toInt() }
    var descCount = 0
    students.forEach {
        descCount += if (it % 2 == 0) it / 2 else it / 2 + 1
    }

    println(descCount)
}