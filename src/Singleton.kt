/**
 * Created by johannesC on 2017/06/30.
 */
class Singleton private constructor() {

    var stringToPrint: String? = null

    companion object {
        val instance: Singleton by lazy { Singleton() }
    }

}

fun main(args: Array<String>) {
    val singleton = Singleton.instance
    singleton.stringToPrint = "Hi"
    println(singleton.stringToPrint)

}