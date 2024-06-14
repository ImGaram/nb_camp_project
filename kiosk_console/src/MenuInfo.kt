package src

import src.data.FoodData
import src.food.category.Category
import java.util.*

class MenuInfo() {
    fun menuInfo(category: Category, scanner: Scanner) {
        while (true) {
            val foods = FoodData.foodList.filter { it.category == category }

            for (i in foods.indices) {
                foods[i].displayInfo()
            }
            println("0. 뒤로가기")

            val menuInfoOption = scanner.next()
            when (menuInfoOption) {
                "1" -> println("1번 선택.")
                "2" -> println("2번 선택.")
                "3" -> println("3번 선택.")
                "0" -> break
                else -> println("올바르지 않은 입력입니다")
            }
        }
    }
}