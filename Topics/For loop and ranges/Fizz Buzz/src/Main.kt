fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    for (i in a..b) {
        var out = ""
        if (i % 3 == 0) out += "Fizz"
        if (i % 5 == 0) out += "Buzz"
        if (out == "") out += i
        println(out)

    }
}