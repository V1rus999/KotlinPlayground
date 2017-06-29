/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {

    print("Add nr 1:")
    val x = readLine()?.toInt() //? is optional it might have a null value
    print("Add nr 2:")
    val y: String? = readLine()
    val z: Int = x!! + y!!.toInt() // !! will throw ex if null
    println("Answer is : " + z)
}