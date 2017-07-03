import kotlin.concurrent.thread

/**
 * Created by johannesC on 2017/07/03.
 */
// Thread are expensive and costs memory. Have a look at kotlin Coroutines
fun main(args: Array<String>) {
    val background = BasicThread()
    background.start() //Old boring way

    thread { runCounter() } // Cooler way
}

fun runCounter() {
    var count = 0

    while (count <= 10) {
        println("Count (${Thread.currentThread().name}) : $count")
        count++

        try {
            Thread.sleep(300)
        } catch (ex: Exception) {
            println("Exception $ex")
        }
    }
}

class BasicThread : Thread() {

    override fun run() {
        runCounter()
    }

}