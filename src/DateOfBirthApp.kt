import java.util.*

/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {
    println("What is your date of birth : ")
    val dob: Int = readLine()!!.toInt()
    val currentDate: Int = Calendar.getInstance().get(Calendar.YEAR)

    val answer = currentDate - dob
    println("Your age is : $answer")

    if (answer >= 18) {
        println("Your are old enough to enter")
    }

    when (answer) {
        in 19..23 -> println("You between 19 and 23")
        else -> println("end")
    }

    for (item in 1..3) {
        println("$item")
    }
}