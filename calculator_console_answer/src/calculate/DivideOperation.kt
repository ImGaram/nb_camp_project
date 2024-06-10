package src.calculate

class DivideOperation: Calculator() {
    override fun operate(num1: Int, num2: Int) {
        val result = num1 / num2
        println("나눗셈 결과는 ${result}입니다.")
    }
}