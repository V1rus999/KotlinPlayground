/**
 * Created by johannesC on 2017/07/03.
 */


fun main(args: Array<String>) {
    val result = callUsers("123")

    when (result) {
        is Success -> {
            val dotComUser = result.users.take(2).filter { it.endsWith(".com") }
            println(dotComUser)
        }
        is Failure -> println(result.message)
    }
}

fun callUsers(id: String): DefaultCallback {
    val emails = arrayListOf<String>()
    emails.add("john.com")
    emails.add("riette.co.za")
    emails.add("koos.com")
    emails.add("piet.au")
    emails.add("john.nz")
    return Success(emails)
}


open class DefaultCallback

data class Success(val users: List<String>) : DefaultCallback()
data class Failure(val message: String) : DefaultCallback()