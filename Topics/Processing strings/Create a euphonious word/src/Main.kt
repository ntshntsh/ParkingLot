/*fun main() {
    val vowels = "aeiouy"
    var n = ""
    readln().forEach { if (vowels.contains(it)) n += "a" else n += "b" }
    var r = 0
    n.split("a").forEach { r += (it.length - 1) / 2 }
    n.split("b").forEach { r += (it.length - 1) / 2 }
    println(r)
}*/

fun main() = print(Regex("([aeiouy]{3,}|[^aeiouy]{3,})").findAll(readln()).sumOf { (it.value.length - 1) / 2 })