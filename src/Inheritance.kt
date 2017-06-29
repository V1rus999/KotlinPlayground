/**
 * Created by johannesC on 2017/06/29.
 */
open class BasicDriving { //Open : This class can be inherited. No Open : This class is final

    var speed: Int = 0;

    fun faster(speed: Int) {
        this.speed += speed
        println("Speed : ${this.speed}")
    }

    fun slower(speed: Int) {
        this.speed -= speed
        println("Speed : ${this.speed}")
    }

    open fun getMaxSpeed(): Int { //All methods are final so need to add open for overrides
        return 50
    }

}

class AdvancedDriving : BasicDriving() {

    fun handbrake() {
        speed = 0
        println("Speed : $speed")
    }

    override fun getMaxSpeed(): Int { //Override lets compiler know you want to make changes to base method
        return 100
    }
}

fun main(args: Array<String>) {
    val aDriving = AdvancedDriving()
    aDriving.faster(50)
    aDriving.slower(20)
    aDriving.handbrake()
    println("Max Speed ${aDriving.getMaxSpeed()}")

    val bDriving = AdvancedDriving() as BasicDriving //Casting
}