package src

import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    println("=========================계산기 v1=========================")
    println("계산을 시작할까요?")
    println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")

    while (true) {
        val mainInput = next()
        // mainInput을 올바르게 작성시키기 위한 try catch
        try {
            if (mainInput.toInt() == 0) {
                // 계산기 시작.
                println("계산을 시작합니다.")
                println("어떤 연산을 하시겠습니까?(1: 덧셈, 2: 뺄셈, 3: 곱셈, 4: 나눗셈, 0: 연산 종료")
                while (true) {
                    try {
                        val calculateValue = next()
                        if (calculateValue.toInt() == 0) break
                        calculation(calculateValue = calculateValue.toInt())
                    } catch (e: Exception) {
                        println("올바른 문자를 입력해 주쇼..")
                    }
                }

                println("계산기를 종료합니다.")
                println("=========================계산기 v1=========================")
                break
            } else if (mainInput.toInt() == -1) {
                // 계산기 종료
                println("계산기를 종료합니다.")
                println("=========================계산기 v1=========================")
                break
            } else {
                println("올바른 숫자를 입력하세요.")
                println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")
                continue
            }
        } catch (e: Exception) {
            println("문자 입력은 안되.")
            println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")
        }
    }
}

private fun calculation(calculateValue: Int) {
    println("연산하기.")
}