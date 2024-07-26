fun main() {
    val (a, b, c, d) = Array(4) { readln().toInt() }

    for (i in 0..1000) {
        if (((a * i + b) * i + c) * i + d == 0) println(i)
    }
}