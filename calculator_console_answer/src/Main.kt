package src

import src.calculate.*

fun main() {
    val addCalc = Calculator(AddOperation())
    println("10 + 20 = ${addCalc.operate(10, 20)} 입니다.")

    val minusCalc = Calculator(SubstractOperation())
    println("20 - 10 = ${minusCalc.operate(20, 10)} 입니다.")

    val multiplyCalc = Calculator(MultiplyOperation())
    println("10 * 20 = ${multiplyCalc.operate(10, 20)} 입니다.")

    val divCalc = Calculator(DivideOperation())
    println("20 / 10 = ${divCalc.operate(0, 10)} 입니다.")
}