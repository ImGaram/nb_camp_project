package src.calculate

class Calculator {

    fun addOperator(num1: Int, num2: Int) {
        val result = num1 + num2
        println("덧셈 결과는 ${result}입니다.")
    }

    fun minusOperator(num1: Int, num2: Int) {
        val result = num1 - num2
        println("뺄셈 결과는 ${result}입니다.")
    }

    fun multiplyOperator(num1: Int, num2: Int) {
        val result = num1 * num2
        println("곱셈 결과는 ${result}입니다.")
    }

    fun divideOperator(num1: Int, num2: Int) {
        val result = num1 / num2
        println("나눗셈 결과는 ${result}입니다.")
    }

    fun restOperator(num1: Int, num2: Int) {
        val result = num1 % num2
        println("나머지 값은 ${result}입니다.")
    }
}