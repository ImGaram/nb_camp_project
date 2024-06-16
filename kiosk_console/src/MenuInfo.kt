package src

import src.data.FoodData
import src.data.ShoppingBasket
import src.food.category.Category
import java.util.*

class MenuInfo() {
    private val shoppingBasket = ShoppingBasket.shoppingBasket

    fun menuInfo(category: Category, scanner: Scanner) {
        while (true) {
            val foods = FoodData.foodList.filter { it.category == category }

            println("[ ${category.name} ]")
            for (i in foods.indices) {
                foods[i].displayInfo()
            }

            println("\n[ ORDER MENU ]")
            println("4. 주문         | 장바구니를 확인 후 주문합니다")
            println("5. 취소         | 진행중인 주문을 취소합니다")

            println("\n0. 뒤로가기")

            val menuInfoOption = scanner.next()
            when (menuInfoOption) {
                "1" -> {
                    println("${foods[0].name}을(를) 장바구니에 추가하였습니다.")
                    shoppingBasket.add(foods[0])
                }
                "2" -> {
                    println("${foods[1].name}을(를) 장바구니에 추가하였습니다.")
                    shoppingBasket.add(foods[1])
                }
                "3" -> {
                    println("${foods[2].name}을(를) 장바구니에 추가하였습니다.")
                    shoppingBasket.add(foods[2])
                }
                "4" -> {
                    val order = Order()
                    // 장바구니 화면으로 이동.
                    order.orderMenu(scanner)
                }
                "5" -> {
                    println("장바구니를 비웠습니다.")
                    shoppingBasket.clear()
                }
                "0" -> break
                else -> println("올바르지 않은 입력입니다")
            }
        }
    }
}