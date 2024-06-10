package src

import src.calculate.*
import src.stack.MyStack

fun main() {
    val addCalc = Calculator(AddOperation())
    println("10더하기 20 결과는 : ${addCalc.operate(10, 20)} 입니다")

    val minusCalc = Calculator(SubstractOperation())
    println("20빼기 10 결과는 : ${minusCalc.operate(20, 10)} 입니다")

    val multipleCalc = Calculator(MultiplyOperation())
    println("10곱하기 20 결과는 : ${multipleCalc.operate(10, 20)} 입니다")

    val divideCalc = Calculator(DivideOperation())
    println("20나누기 10 결과는 : ${divideCalc.operate(20, 10)} 입니다")

    val myStack = MyStack()
    val calResult = myStack.getPostFixExpressionOperation("(2 + 4) * 4 / 2 * 12")
    println("결과: ${calResult}입니다")
}