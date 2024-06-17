package src.menu

class Food(name: String, price: Double, category: String, description: String) {
    var name: String
    var price: Double
    var category: String
    var description: String

    init {
        this.name = name
        this.price = price
        this.category = category
        this.description = description
    }

    fun displayInfo() {
        println("카테고리: $category, 가격: $price, 이름: $name, [ $description ]")
    }
}