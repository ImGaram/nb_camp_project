package src.food

import src.food.category.Category

open class Food(
    val foodNum: Int,
    val name: String,
    val price: Int,
    val description: String,
    val category: Category
) {
    fun displayInfo() {
        println("$foodNum. $name                  | W$price | $description")
    }

    fun displayShoppingBasket() {
        println("$name                  | W$price | $description")
    }
}