fun main() {
    val str = readln()
    val sum = str.sumOf { i -> i.digitToInt() }
    val half = str.substring(str.length / 2).sumOf { i -> i.digitToInt() }

    println(if (sum % half == 0) "YES" else "NO")
}