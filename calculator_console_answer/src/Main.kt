package src

import src.calculate.Calculator

fun main() {
    val calculator = Calculator()

    while (true) {
        println("[1] 덧셈, [2] 뺄셈, [3] 곱셈, [4] 나눗셈, [5] 나머지, [-1] 종료")
        val select = readln().toInt()

        if (select == -1) break

        println("첫 번째 숫자를 입력하세요.")
        val num1 = readln().toInt()
        println("두 번째 숫자를 입력하세요.")
        val num2 = readln().toInt()

        if (select == 1) calculator.addOperator(num1, num2)
        else if (select == 2) calculator.minusOperator(num1, num2)
        else if (select == 3) calculator.multiplyOperator(num1, num2)
        else if (select == 4) calculator.divideOperator(num1, num2)
        else if (select == 5) calculator.restOperator(num1, num2)
        else break
    }

    println("수고하셨습니다.")
}