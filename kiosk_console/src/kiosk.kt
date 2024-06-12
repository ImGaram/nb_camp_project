package src

import src.menu.*
import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val ownMoney = initOwnMoney(this)

    mainMenu()
}

// 소지금 불러오기.
private fun initOwnMoney(sc: Scanner): Int {
    var ownMoney = 0
    while (true) {
        try {
            println("초기 소지금을 입력하세요.")
            val money = sc.next()
            ownMoney = money.toInt()
            break
        } catch (e: Exception) {
            println("소지금이 올바르지 않습니다")
        }
    }

    return ownMoney
}

private fun Scanner.mainMenu() {
    while (true) {
        println("[\"죽여주게 맛있는 햄버거집\"]")
        println("[ 메인 메뉴 ]")
        println("[1] 햄버거               | 죽여주게 맛있는 햄버거")
        println("[2] 서브 메뉴             | 죽여주게 맛있는 서브 메뉴")
        println("[3] 음료                 | 죽여주게 맛있는 음료")
        println("[0] 종료                 | 프로그램 종료")

        val mainMenuOption = next()
        when (mainMenuOption) {
            "1" -> { menuInfo("햄버거") }
            "2" -> { menuInfo("서브 메뉴") }
            "3" -> { menuInfo("음료") }
            "0" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("올바르지 않은 입력입니다")
        }
    }
}

private fun Scanner.menuInfo(category: String) {
    while (true) {
        when (category) {
            "햄버거" -> {
                val burger1 = Burger1()
                val burger2 = Burger2()
                val burger3 = Burger3()

                println("[ 햄버거 ]")
                burger1.displayInfo()
                burger2.displayInfo()
                burger3.displayInfo()
            }
            "서브 메뉴" -> {
                val frenchFries = FrenchFries()
                val cheeseStick = CheeseStick()
                val redBeanShavedIce = RedBeanShavedIce()

                println("[ 서브 메뉴 ]")
                frenchFries.displayInfo()
                cheeseStick.displayInfo()
                redBeanShavedIce.displayInfo()
            }
            "음료" -> {
                val cola = Cola()
                val coffee = Coffee()
                val water = Water()

                println("[ 음료수 ]")
                cola.displayInfo()
                coffee.displayInfo()
                water.displayInfo()
            }
        }
        println("0. 뒤로가기")

        val menuInfoOption = next()
        when (menuInfoOption) {
            "1" -> println("1번 선택.")
            "2" -> println("2번 선택.")
            "3" -> println("3번 선택.")
            "0" -> break
            else -> println("올바르지 않은 입력입니다")
        }
    }
}