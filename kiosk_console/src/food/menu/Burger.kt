package src.food.menu

import src.food.Food
import src.food.category.Category

class Burger(
    foodNum: Int,
    name: String,
    price: Int,
    description: String
): Food(foodNum, name, price, description, Category.HAMBURGER) {
}