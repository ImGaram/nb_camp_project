package src.food.menu

import src.food.Food
import src.food.category.Category

class SubMenu(
    foodNum: Int,
    name: String,
    price: Int,
    description: String
): Food(foodNum, name, price, description, Category.SUBMENU) {
}