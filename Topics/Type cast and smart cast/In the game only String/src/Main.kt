@Suppress("UNCHECKED_CAST")
fun <T> getStringsOnly(list: List<T>): List<String> = list.filter { it is String } as List<String>