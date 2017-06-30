import java.io.FileWriter

/**
 * Created by johannesC on 2017/06/30.
 */
fun main(args: Array<String>) {
    val fPrint = FilePrinteable()
    val printr = FilePrinter()
    printr.print(fPrint)
}

class FilePrinteable : Printable {

    override fun print(): String {
        return "Something to print to file"
    }

}

class FilePrinter : Printer() {

    override fun <T : Printable> print(t1: T) {
        try {
            val fileWriter = FileWriter("testText.txt")
            fileWriter.write(t1.print())
            fileWriter.close()
        } catch (e: Throwable) {
            println("Issue writing file : $e")
        }
    }
}