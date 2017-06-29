/**
 * Created by johannesC on 2017/06/29.
 */
fun main(Args: Array<String>) {
    val dog = Dog()
    dog.makeNoise()
}

interface Animal {

    fun makeNoise()
}

class Dog : Animal {

    override fun makeNoise() {
        println("Woof")
    }
}