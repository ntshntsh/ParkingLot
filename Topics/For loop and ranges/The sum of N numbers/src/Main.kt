fun main() {
    var sum = 0
    for (i in 0 until readLine()!!.toInt()) {
        sum += readLine()!!.toInt()
    }
    println(sum)
}