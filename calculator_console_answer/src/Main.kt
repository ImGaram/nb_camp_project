package src

import src.calculate.Calculator

fun main() {
    val calculator = Calculator()
    calculator.addOperator(10, 20)
    calculator.minusOperator(20, 10)
    calculator.multiplyOperator(10, 20)
    calculator.divideOperator(20, 10)
}