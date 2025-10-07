package com.lannstark.lec10

// 10.1
//class Penguin(
//    species: String
//) : Animal(species, 2){
//    private val wingCount: Int = 2
//
//    override fun move() {
//        println("펭귄이 움직인다~ 꽥꽥")
//    }
//
//    override val legCount: Int
//    get() = super.legCount + this.wingCount //?? , super는 상위 클래스 프로퍼티에 접근할 때...
//
//    // 중요: 자바, 코틀린 모두 추상 클래스는 인스턴스화 할 수 없다...
//
//
//}

// 10.2 인터페이스
//Flyable과 Swimmable을 구현하자.
// 앞의 펭귄 클래스 재활용
class Penguin(
    species: String
) : Animal(species, 2), Swimmable, Flyable{
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다~ 꽥꽥")
    }

    override val legCount: Int
    get() = super.legCount + this.wingCount //?? , super는 상위 클래스 프로퍼티에 접근할 때...

    override fun act() {
        super<Swimmable>.act()
        super<Flyable>.act()
    }
    // 중요: 자바, 코틀에서 모두 인터페이스를 인스턴스화 할 수 없다.
}