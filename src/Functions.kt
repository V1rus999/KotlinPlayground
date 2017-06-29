/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {
    println(sum(1, 2))
    voidFun(3)
}

fun sum(n1: Int, n2: Int): Int {
    return n1 + n2
}

fun voidFun(n1: Int) {
    println(n1)
}

