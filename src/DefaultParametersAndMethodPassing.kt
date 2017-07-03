/**
 * Created by johannesC on 2017/07/03.
 */
fun main(args: Array<String>) {
    methodWithCodeBlockAndDefaultParams { funcOne() }
    methodWithCodeBlockAndDefaultParams(false, null, { funcTwo() })
    methodIntoTheVoid { funcOne() }
}

fun funcOne(): String {
    return "funcOne"
}

fun funcTwo(): String {
    return "funcTwo"
}

fun methodWithCodeBlockAndDefaultParams(shouldPrint: Boolean = true, defaultPrint: String? = "Method Run", codeBlock: () -> String) {
    if (shouldPrint) println("$defaultPrint")
    println(codeBlock())
}

fun methodIntoTheVoid(codeBlock: () -> Unit) { //Unit means void, it doesn't return anything
    codeBlock()
}