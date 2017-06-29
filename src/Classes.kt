/**
 * Created by johannesC on 2017/06/26.
 */
class Car(make: String, model: String) { //This is a primary constructor

    init {
        println("Make $make")
        println("Model $model")
    }

    fun getPrice() : Int {
        return 1000000
    }
}

//class Seat { //This is a primary contructor
//
//    constructor(make: String, model: String) { //This is a normal "Java ish" constructor
//
//    }
//
//    constructor(make: String, model: String, price:Int) { //This is a normal "Java ish" constructor
//
//    }
//
//    fun getPrice() : Int {
//        return 999
//    }
//}

fun main(args: Array<String>) {
    val hilux = Car("Toyota", "Hilux")
    println("Price ${hilux.getPrice()}")
}