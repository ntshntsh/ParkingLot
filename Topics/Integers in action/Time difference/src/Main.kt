const val HMS = 3
const val TIME_UNITS = 60

fun main() {
    val firstMoment = Array(HMS) { readLine()!!.toInt() }
    val secondMoment = Array(HMS) { readLine()!!.toInt() }

    println(getSeconds(secondMoment) - getSeconds(firstMoment))

}

fun getSeconds(moment: Array<Int>): Int {
    return moment[0] * TIME_UNITS * TIME_UNITS + moment[1] * TIME_UNITS + moment[2]
}