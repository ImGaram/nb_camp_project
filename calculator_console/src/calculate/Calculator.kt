package src.calculate

class Calculator: AbstractOperation() {
    override fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun minus(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    override fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }

    override fun divide(num1: Int, num2: Int): Int {
        return num1 / num2
    }
}