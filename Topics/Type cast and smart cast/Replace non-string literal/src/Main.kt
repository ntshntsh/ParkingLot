fun convertToStringList(list: List<Any>): List<String> {
    val stringList = mutableListOf<String>()
    for (element in list) {
        val stringElement = element as? String
        if (stringElement == null) {
            stringList.add("N/A")
        } else {
            stringList.add(stringElement)
        }
    }
    return stringList
}