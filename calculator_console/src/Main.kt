package src

import src.calculate.Calculator
import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    println("=========================계산기 v1=========================")
    println("계산을 시작할까요?")
    println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")

    var isCalculatorFinish = false
    while (true) {
        // 계산기 종료 여부가 true면 종료
        if (isCalculatorFinish) break

        val mainInput = next()
        // mainInput을 올바르게 작성시키기 위한 try catch
        try {
            if (mainInput.toInt() == 0) {
                // 계산기 시작.
                println("계산을 시작합니다.")
                while (true) {
                    println("사칙연산식을 입력하세요(종료하려면 ` 입력).")

                    val formula = next()
                    if (formula == "`") {
                        println("계산기를 종료합니다.")
                        println("=========================계산기 v1=========================")
                        isCalculatorFinish = true
                        break
                    } else {
                        // 정규 표현식을 이용한 수식 분할(여러 개의 문자를 기준으로 분할 가능함).
                        val splitFormula = formula.split("+", "-", "*", "/")
                        val splitFormulaSymbol = formula.filter { it in setOf('+', '-', '*', '/') }.map { it.toString() }
                        // splitFormula에서 숫자와 괄호"()"만 포함되도록 하기(정규 표현식 사용).
                        if (!splitFormula.all { it.matches(Regex("\\d*")) })
                            println("연산식이 문자를 포함하고 있습니다. 다시 시도해 주세요.")
                        else {
                            calculation(
                                splitFormula = splitFormula,
                                splitFormulaSymbol = splitFormulaSymbol
                            )
                        }
                    }
                }
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
            println(e.printStackTrace())
            println("문자 입력은 안되.")
            println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")
        }
    }
}

private fun calculation(splitFormula: List<String>, splitFormulaSymbol: List<String>) {
    // 수식을 입력받아 계산하기.
    val calculator = Calculator()
    val mutableSplitFormula = splitFormula.map { it.toInt() }.toMutableList()
    val mutableSplitFormulaSymbol = splitFormulaSymbol.toMutableList()

    println(mutableSplitFormula)
    println(mutableSplitFormulaSymbol)

    var calculateResult = mutableSplitFormula[0]
    mutableSplitFormula.removeAt(0)

    // todo :: 계산 우선순위 부여해서 계산하도록 구현(*, /)
    while (mutableSplitFormula.size > 0) {
        when (mutableSplitFormulaSymbol[0]) {
            "+" -> calculateResult = calculator.add(calculateResult, mutableSplitFormula[0])
            "-" -> calculateResult = calculator.minus(calculateResult, mutableSplitFormula[0])
            "*" -> calculateResult = calculator.multiply(calculateResult, mutableSplitFormula[0])
            "/" -> calculateResult = calculator.divide(calculateResult, mutableSplitFormula[0])
        }
        mutableSplitFormula.removeAt(0)
        mutableSplitFormulaSymbol.removeAt(0)
    }

    println("계산 결과: $calculateResult")
}