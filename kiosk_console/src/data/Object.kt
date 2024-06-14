package src.data

import src.food.Food

class FoodData {
    companion object {
        val foodList = arrayListOf<Food>()

        fun addFood(food: Food) {
            foodList.add(food)
        }
    }
}

class OwnMoney {
    companion object {
        var ownMoney = 0

        fun initMoney(money: Int) {
            ownMoney = money
        }

        fun minusMoney(pay: Int) {
            ownMoney -= pay
        }
    }
}