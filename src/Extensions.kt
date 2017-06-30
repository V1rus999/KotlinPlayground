/**
 * Created by johannesC on 2017/06/30.
 */
//Extensions == add methods to an already created class
class AndroidSharedPreferences {

    private var valueToAdd = ""

    fun addValue(valueToAdd: String) {
        this.valueToAdd = valueToAdd
    }

    fun save() {
        println("Saving $valueToAdd to database")
    }
}

fun AndroidSharedPreferences.saveValue(valueToAdd: String) {
    this.addValue(valueToAdd)
    this.save()
}

fun main(args: Array<String>) {

    val badSharedPrefs = AndroidSharedPreferences()
    badSharedPrefs.addValue("ABC")
    badSharedPrefs.save() //We have to make two method calls just to save a value

    val extendedSharedPrefs = AndroidSharedPreferences()
    extendedSharedPrefs.saveValue("ABCDEF")
}

