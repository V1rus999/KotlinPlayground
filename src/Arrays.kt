/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {
    val strArray = Array(3) { "" }
    strArray[0] = "00"
    strArray[1] = "11"
    strArray[2] = "22"
    for (item in strArray) {
        println(item)
    }

    println("==END OF ARRAY==")

    val strArraylist = ArrayList<String>()
    strArraylist.add("00")
    strArraylist.add("11")
    strArraylist.add("22")
    for (item in strArraylist) {
        println(item)
    }

    println(strArraylist)

    println("==END OF ARRAYLIST==")

    val map = HashMap<Int, String>()
    for (keys in 0..2) {
        map.put(keys, keys.toString() + keys.toString())
    }

    for (key in map) {
        println(key.value)
    }

    println("==END OF HASHMAP==")

    println("\n==START OF KOTLIN COLLECTIONS==\n")

    val kMap = hashMapOf<Int, String>()
    for (keys in 0..2) {
        kMap.put(keys, keys.toString() + keys.toString())
    }

    kMap[1] = "abc"

    for (key in kMap) {
        println(key.value)
    }

    println("==END OF Kotlin HASHMAP==")

    val set = setOf(1, 2, 3)
    // set.add() cannot add because immutable

    for (element in set) {
        println(element)
    }

    val mSet = mutableSetOf(1, 2, 3)
    mSet.add(4)
    for (element in mSet) {
        println(element)
    }

    println("==END OF Kotlin MUTABLE SET==")
}