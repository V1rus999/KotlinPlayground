/**
 * Created by johannesC on 2017/06/26.
 */
fun main(args: Array<String>) {

    loop@ for (item in 1..10) { //Adds a label loop this means we can skip boolean flags

        for (internalItem in 1..5) {
            println("Item:$item  Internal:$internalItem")
            if (internalItem == 2) {
                break@loop //Break out of the outside loop
            }
        }

    }

}