package src

import src.food.category.Category
import java.util.*

class MainMenu {
    private val menuInfo = MenuInfo()

    fun mainMenu(scanner: Scanner) {
        while (true) {
            println("[\"죽여주게 맛있는 햄버거집\"]")
            println("[ 메인 메뉴 ]")
            println("[1] 햄버거               | 죽여주게 맛있는 햄버거")
            println("[2] 서브 메뉴             | 죽여주게 맛있는 서브 메뉴")
            println("[3] 음료                 | 죽여주게 맛있는 음료")
            println("[0] 종료                 | 프로그램 종료")

            val mainMenuOption = scanner.next()
            when (mainMenuOption) {
                "1" -> { menuInfo.menuInfo(Category.HAMBURGER, scanner) }
                "2" -> { menuInfo.menuInfo(Category.SUBMENU, scanner) }
                "3" -> { menuInfo.menuInfo(Category.DRINK, scanner) }
                "0" -> {
                    println("프로그램을 종료합니다.")
                    break
                }
                else -> println("올바르지 않은 입력입니다")
            }
        }
    }
}