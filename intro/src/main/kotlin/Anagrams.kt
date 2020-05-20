package by.dma

class Anagrams {
    fun String.sort(): List<Char> = this.toList().sorted()

    fun count(str: String): Int {
        var count = 0
        for (i in 1 until str.length) {
            var substrings = str.windowed(i, 1)
                    .map { it.sort() }
                    .toMutableList()
            while (substrings.isNotEmpty()) {
                val substring = substrings.removeAt(0)
                count += substrings.count { it == substring }
            }
        }
        return count
    }
}
