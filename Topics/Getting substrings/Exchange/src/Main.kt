fun main() {
    val s = readln()
    println(s.replace(s.last(), s.first()).replaceFirst(s.first(), s.last()))
}