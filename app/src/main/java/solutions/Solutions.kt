package solutions


/**
 * find out if the given two strings are anagrams
 */
fun isAnagram(s1: String, s2: String): Boolean {
    val charMap1 = createMap(s1)
    val charMap2 = createMap(s2)

    if (charMap1.size != charMap2.size) {
        return false
    }

    for((ch, count) in charMap1) {
        if (charMap2[ch] != count) return false
    }
    return true
}

fun createMap(str: String): HashMap<Char, Int> {
    val charMap = hashMapOf<Char, Int>()
    for(ch in str) {
        var current = charMap[ch] ?: 0
        charMap[ch] = ++current
    }
    return charMap
}

/**
 * get the matching elements in an integer array
 */
fun getMatching(arr: List<Int>): List<Int> {
    val intSet = hashSetOf<Int>()
    val matchSet = hashSetOf<Int>()
    for(num in arr) {
        if (!intSet.add(num)) {
            matchSet.add(num)
        }
    }
    return matchSet.toList()
}
