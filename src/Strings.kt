/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {
    val text = "Hello"
    println(getChar(2, text))
    println("Upper : " + text.toUpperCase())
    println("Lower : ${text.toLowerCase()}")

    for (char in text) {
        println(char)
    }
}

fun getChar(index: Int, text: String): Char {
    return text[index]
}