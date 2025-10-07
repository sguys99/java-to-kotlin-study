package com.lannstark.lec10

// 10.1 Animal 클래스를 상속받아서 클래스를 만들자.
class Cat(
    species: String
) : Animal(species, 4){ // 상속 부분... 상속 콜록은 공백 후 : 사용, 타입 지정은 붙여서 : 사용
    override fun move() {
        println("고양이가 사뿐사뿐 걸어가")
    }
}