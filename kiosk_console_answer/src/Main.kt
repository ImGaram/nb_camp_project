package src

fun main() {

    while(true) {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요")
        println("[MYSHOP MENU]")
        println("1. Burgers        | 앵거스 비프 통살을 다져만든 버거")
        println("2. Forzen Custard | 매장에서 신선하게 만드는 아이스크림")
        println("3. Drinks         | 매장에서 직접 만드는 음료")
        println("4. Beer           | 뉴욕 브루클린 브루어리에서 양조한 맥주")
        println("0. 종료            | 프로그램 종료")

        var categorySelect = readLine()!!.toInt()

        when(categorySelect) {
            1 -> {
                println("1. ShackBurger    | W 6.9 | 토마토,양상추,쉑소스가 토핑된 치즈버거")
                println("2. SmokeBurger    | W 8.9 | 체리 페퍼에 쉑소스가 토핑된 치즈버거")
                println("3. Shroom Burger  | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거")
                println("4. Cheese Burger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")
                println("5. Hamburger      | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거")
                println("0. 종료            | 뒤로가기")
                var menuSelect = readLine()!!.toInt()
                when(menuSelect) {
                    0 -> {

                    }
                    1 -> {
                        println("ShackBurger 입니다~")
                    }
                }
            }
            2 -> {
                println("1. Plain Ice Cream     | W 12.1 | 바닐라 아이스크림")
                println("2. Chocolate Ice Cream | W 10.2 | 초콜릿 아이스크림")
                println("3. Fruits Ice Cream    | W 15.14 | 과일 아이스크림")
                println("4. Nuts Ice Cream      | W 15.14 | 아몬드 아이스크림")
                println("5. Ice Milk            | W 9.9 | 저지방 아이스크림")
                println("0. 종료                 | 뒤로가기")
                var menuSelect = readLine()!!.toInt()
                when(menuSelect) {

                }
            }
            3 -> {
                println("1. Ade        | W 7.5 | 에이드")
                println("2. Americano  | W 6.4 | 아메리카노")
                println("3. Beverage   | W 6.8 | 음료수")
                println("4. Black Tea  | W 7.7 | 홍차")
                println("5. Barley Tea | W 8.9 | 보리차")
                println("0. 종료        | 뒤로가기")
                var menuSelect = readLine()!!.toInt()
                when(menuSelect) {

                }
            }
            4 -> {
                println("1. Bokbunja           | W 16.2   | 복분자")
                println("2. Bourbon            | W 19.2   | 버번위스키")
                println("3. Cocktail           | W 15.4   | 칵테일")
                println("4. Gin                | W 25.2   | 진")
                println("5. Armand de Brignac  | W 999.99 | 아르망디 샴페인")
                println("0. 종료        | 뒤로가기")
                var menuSelect = readLine()!!.toInt()
                when(menuSelect) {

                }
            }
            0 -> {
                println("프로그램을 종료합니다.")
                break
            }
        }
    }

}