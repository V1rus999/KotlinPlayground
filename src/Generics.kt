/**
 * Created by johannesC on 2017/06/30.
 */
fun main(args: Array<String>) {
    val paper = Paper()
    val toFile = PrintToFile()
    val printer = Printer()
    printer.print(paper)
    printer.print(toFile)
}

interface Printable {

    fun print(): String
}

class Paper : Printable {

    override fun print(): String {
        return "I am writing on paper, not good for the environment"
    }

}

class PrintToFile : Printable {
    override fun print(): String {
        return "I am writing to file, better for the environment"
    }

}

class Printer {

    fun <T : Printable> print(t1: T) {
        println(t1.print())
    }
}

