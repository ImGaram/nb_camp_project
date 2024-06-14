package src

import src.data.FoodData
import src.data.OwnMoney
import src.food.menu.Burger
import src.food.menu.Drink
import src.food.menu.SubMenu
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    initOwnMoney(this)
    init()

    MainMenu().mainMenu(this)
}

private fun init() {
    FoodData.addFood(Burger(1, "햄버거 1", 3500, "그냥 햄버거 1"))
    FoodData.addFood(Burger(2, "햄버거 2", 5500, "그냥 햄버거 2"))
    FoodData.addFood(Burger(3, "햄버거 3", 7000, "그냥 햄버거 3"))
    FoodData.addFood(Drink(1, "콜라", 1500, "그냥 콜라"))
    FoodData.addFood(Drink(2, "커피", 2500, "그냥 커피 안 뜨거움"))
    FoodData.addFood(Drink(3, "물", 1000, "그냥 물"))
    FoodData.addFood(SubMenu(1, "감자튀김", 1500, "그냥 감자튀김"))
    FoodData.addFood(SubMenu(2, "치즈스틱", 2000, "그냥 치즈스틱"))
    FoodData.addFood(SubMenu(3, "팥빙수", 3500, "그냥 팥빙수"))
}

// 소지금 불러오기.
private fun initOwnMoney(sc: Scanner) {
    while (true) {
        try {
            println("초기 소지금을 입력하세요.")
            val money = sc.next()
            OwnMoney.initMoney(money.toInt())
            break
        } catch (e: Exception) {
            println("소지금이 올바르지 않습니다")
        }
    }
}
