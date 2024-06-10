package src

import src.calculate.*

fun main() {
    val calculator1 = AddOperation()
    calculator1.operate(10, 20)

    val calculator2 = SubstractOperation()
    calculator2.operate(20, 10)

    val calculator3 = MultiplyOperation()
    calculator3.operate(10, 20)

    val calculator4 = DivideOperation()
    calculator4.operate(20, 10)
}