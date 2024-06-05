package src.calculate

abstract class AbstractOperation {
    // 덧셈
    abstract fun add(num1: Int, num2: Int): Int
    // 뺄셈
    abstract fun minus(num1: Int, num2: Int): Int
    // 곱셈
    abstract fun multiply(num1: Int, num2: Int): Int
    // 나눗셈
    abstract fun divide(num1: Int, num2: Int): Int
}