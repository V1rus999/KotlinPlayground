import java.math.BigDecimal

/**
 * Created by johannesC on 2017/07/03.
 */
fun Int.toBigDecimal() = BigDecimal(this) //Extension to easily convert to big decimal

infix fun Int.percentOf(percentage: Int) = this.toBigDecimal().multiply(this.toBigDecimal()).divide(this.toBigDecimal()) //Infix means you can write ticketPrice percentOf 14

data class Money(val amount: BigDecimal, val currency: String) //Data class generates all POJO methods for you.

operator fun Money.plus(money: Money) =
        if (currency == money.currency) {
            Money(amount + money.amount, currency)
        } else
            throw IllegalArgumentException("Wrong currency") //This overrides the + operator so you can easily do val costs = tickets + popcorn

fun main(args: Array<String>) {
    val ticketPrice = 100
    val ticketPriceWithoutVat = ticketPrice percentOf 86
    val tickets = Money(ticketPrice.toBigDecimal(), "R")

    val popCornPrice = 500.bd
    val popcorn = Money(popCornPrice, "R")

    val costs = tickets + popcorn
    println("Tickets : ${tickets.amount} + Popcorn : ${popcorn.amount} = $costs")
    sendPayment(message = "Hey", money = costs) //Named parameters, useful in legacy code
}

fun elvisPrint(money: Money?) { //? elvis operator means money can be null. !! = Throw exception if null. ? = Shorthand if != null
    println("${money?.amount}")
}

private val Int.bd: BigDecimal
    get() = BigDecimal(this) //This is an extension property. This means typing 100.bd will return a type of BigDecimal. Looks better than 100.toBigDecimal()

fun sendPayment(money: Money, message: String = "") { //Default parameter
    println("Sending ${money.amount}")
}

fun convertMoney(money: BigDecimal, percentage: BigDecimal) = money * percentage //Inline function

fun convertToDollars(money: Money): Money = when (money.currency) {
    "$" -> money
    "R" -> Money(convertMoney(money.amount, BigDecimal(14)), "$")
    else -> throw IllegalArgumentException("Not supported")
}