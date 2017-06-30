/**
 * Created by johannesC on 2017/06/30.
 */
fun main(args: Array<String>) {
    val userInfo = UserInfo();
    println("Is Blacklisted ${userInfo.isBlackListed()}")
}

abstract class CreditCard {

    fun creditRating(): Int {
        return 123
    }

    abstract fun isBlackListed(): Boolean

}

class UserInfo : CreditCard() {
    override fun isBlackListed(): Boolean {
        return getUserRating() >= 100
    }

    fun getUserRating(): Int {
        return creditRating();
    }
}