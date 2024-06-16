package src

import src.data.OwnMoney
import src.data.ShoppingBasket
import java.util.Scanner

class Order {
    private val shoppingBasket = ShoppingBasket.shoppingBasket
    private val ownMoney = OwnMoney.ownMoney

    fun orderMenu(scanner: Scanner) {
        val totalPrice = shoppingBasket.sumOf { it.price }

        while (true) {
            if (shoppingBasket.isEmpty()) {
                println("장바구니가 비어 있습니다")
                break
            } else {
                println("아래와 같이 주문 하시겠습니까?")
                println("\n[ Orders ]")

                for (i in shoppingBasket.indices) {
                    shoppingBasket[i].displayShoppingBasket()
                }

                println("\n[ Total ]")
                println("W$totalPrice")
                println("\n1.주문         2. 메뉴판          3. 장바구니 비우기")

                val orderInput = scanner.next()
                when (orderInput) {
                    "1" -> {
                        // 주문하기
                        if (ownMoney >= totalPrice) {
                            OwnMoney.minusMoney(totalPrice)
                            shoppingBasket.clear()
                            println("주문이 완료되었습니다. 남은 잔액은 ${OwnMoney.ownMoney}W 입니다.")
                        } else {
                            println("현재 잔액은 ${ownMoney}W으로 ${totalPrice-ownMoney}W이 부족해서 주문할 수 없습니다.")
                        }
                        break
                    }
                    "2" -> break    // 메뉴 화면으로 돌아가기.
                    "3" -> {
                        // 장바구니 비우기.
                        shoppingBasket.clear()
                        println("장바구니를 비웠습니다.")
                        break
                    }
                    else -> println("잘못된 번호를 입력했습니다.")
                }
            }
        }
    }
}