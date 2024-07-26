fun main() {
    var sum = 0
    for (i in readLine()!!.toInt()..readLine()!!.toInt()) {
        sum += i
    }
    println(sum)
}