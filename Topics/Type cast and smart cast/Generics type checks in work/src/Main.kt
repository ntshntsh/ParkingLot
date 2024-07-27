inline fun <reified T> countElementsOfType(list: List<Any>, clazz: Class<T>): Int {
    var result = 0
    for (item in list) {
        if (item is T) {
            result++
        }
    }
    return result
}