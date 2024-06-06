package src

import src.calculate.Calculator
import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    println("=========================계산기 v1=========================")
    println("계산을 시작할까요?")
    println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")

    var isCalculatorFinish = false
    while (true) {
        // 계산기 종료 여부가 true면 종료
        if (isCalculatorFinish) break

        val mainInput = next()
        // mainInput을 올바르게 작성시키기 위한 try catch
        if (mainInput == "0") {
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
                    val splitFormulaSymbol = formula.filter { it in setOf('+', '-', '*', '/') }.map { it }
                    // splitFormula에서 숫자만 포함되도록 하기(정규 표현식 사용).
                    if (!splitFormula.all { it.matches(Regex("\\d*")) })
                        println("연산식이 문자를 포함하고 있습니다. 다시 시도해 주세요.")
                    else if (splitFormula.any { it.isEmpty() })
                        // splitFormula의 데이터 중 빈값이 존재함(연산식이 올바르게 끝나지 않음.)
                        println("연산식이 올바르게 끝나지 않았습니다. 다시 시도해 주세요.")
                    else {
                        calculation(
                            splitFormula = splitFormula,
                            splitFormulaSymbol = splitFormulaSymbol
                        )
                    }
                }
            }
        } else if (mainInput == "-1") {
            // 계산기 종료
            println("계산기를 종료합니다.")
            println("=========================계산기 v1=========================")
            break
        } else {
            println("올바른 숫자를 입력하세요.")
            println("계산을 시작하려면 0을 입력하고, 종료하려면 -1을 입력하세요.")
        }
    }
}

private fun calculation(splitFormula: List<String>, splitFormulaSymbol: List<Char>) {
    // 수식을 입력받아 계산하기.
    val calculator = Calculator()
    val mutableSplitFormula = splitFormula.map { it.toInt() }.toMutableList()
    val mutableSplitFormulaSymbol = splitFormulaSymbol.map { it.toString() }.toMutableList()

    // 곱하기, 나누기를 우선으로 계산하기
    // 먼저 곱하기, 나누기가 존재하는지 indexOf로 확인해야 함(초기값 -2).
    var multiplyIndex = -2
    var divideIndex = -2
    // 곱하기, 나누기 기호가 없어질 때까지 반복.
    while (multiplyIndex != -1 || divideIndex != -1) {
        // 반복마다 곱하기, 나누기의 위치를 구함.
        multiplyIndex = mutableSplitFormulaSymbol.indexOf("*")
        divideIndex = mutableSplitFormulaSymbol.indexOf("/")

        if (multiplyIndex < divideIndex) {
            // 나누기가 더 먼저 있음
            val divideResult = calculator.divide(mutableSplitFormula[divideIndex], mutableSplitFormula[divideIndex+1])

            // 계산에 사용한 숫자 2개를 지운다.
            mutableSplitFormula.removeAt(divideIndex)
            mutableSplitFormula.removeAt(divideIndex)
            // 계산에 사용한 나누기 기호를 지운다.
            mutableSplitFormulaSymbol.removeAt(divideIndex)
            // 나누기 계산 결과를 추가한다.
            mutableSplitFormula.add(divideIndex, divideResult)
        } else if (multiplyIndex > divideIndex) {
            // 곱하기가 더 먼저 있음
            val multiplyResult = calculator.multiply(mutableSplitFormula[multiplyIndex], mutableSplitFormula[multiplyIndex+1])

            mutableSplitFormula.removeAt(multiplyIndex)
            mutableSplitFormula.removeAt(multiplyIndex)
            mutableSplitFormulaSymbol.removeAt(multiplyIndex)
            mutableSplitFormula.add(multiplyIndex, multiplyResult)
        }
    }

    var calculateResult = mutableSplitFormula[0]
    mutableSplitFormula.removeAt(0)

    while (mutableSplitFormula.size > 0) {
        when (mutableSplitFormulaSymbol[0]) {
            "+" -> calculateResult = calculator.add(calculateResult, mutableSplitFormula[0])
            "-" -> calculateResult = calculator.minus(calculateResult, mutableSplitFormula[0])
        }

        mutableSplitFormula.removeAt(0)
        mutableSplitFormulaSymbol.removeAt(0)

    }

    println("계산 결과: $calculateResult")
}