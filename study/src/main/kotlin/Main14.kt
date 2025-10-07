package com.lannstark.lec14

// ch14. 코틀린에서 다양한 클래스를 다루는 방법
// 1. Data Class
// 2. Enum Class
// 3. Sealed Class, Sealed Interface


// 1. Data Class
data class PersonDto( // 앞에 data를 붙이면 자동으로 equals, hashCode, toString 메서드를 만들어 준다.
    val name: String,
    val age: Int
)

// 2. Enum Class : 추가적인 클래스를 상속받을 수 없다. 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다.
enum class Country(
    private val code: String, //?? 다시 볼것
){
    KOREA("KO"),
    AMERICA("US");
}

// enum class는 when과 함께 사용하여 효용성이 나타남...
fun handleCountry(country: Country){
    when(country){
        Country.KOREA -> println("Korea")
        Country.AMERICA -> println("America")
        // else 작성할 필요 없음. korea, america 뿐이니까.
    }
}

// 3. Sealed Class, Sealed Interface : Sealed 봉인을 한
// 상속이 가능하도록 추상 클래스를 만들까 하는데.. 외부에서는 이 클래스를 상속받지 않도록 하고 싶다면
// 하위 클래스를 봉인하면 됨

// 다시 말해 Sealed class는 컴파일 타임때 하위 클래스의 타입을 모두 기억한다.
// 즉, 런타임 떄 클래스 타입이 추가될 수 없다.
// Enum과 다른점: 클래스를 상속 받을 수 있다. 하위 클래스는 멀티 인스턴스가 가능하다.

sealed class HyundaiCar(
    val name: String,
    val price: Long,
)

class Avante : HyundaiCar("아반떼", 1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)
class Grandeur : HyundaiCar("그렌저", 3_000L)
// sealed를 빼고 본다면 abstract와 같다.
// 그런데 포인트는
// 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉 런타임 때 클래스 타입이 추가될 수 없다.



fun main() {
    val dto1 = PersonDto("유광명", 100)
    val dto2 = PersonDto("유광명", 200)

    println(dto1)
    println(dto1==dto2)
}