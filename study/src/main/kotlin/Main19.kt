import com.lannstark.lec17.Fruit

// ch19. 코틀린의 이모저모
// 1. Type Alias 와 as import
// 2. 구조 분해와 componentN함수
// 3. Jump와 label
// 4. TakeIf와 TakeUnless

// 1. Type Alias 와 as import
// 긴 이름의 클래스 혹은 함수 타입이 있을 태 축약하거나 더 좋은 이름 사용
// 아래의 filter 이후 부분 축약하고 싶을 것이다.
//fun filterFruits(fruits: List<String>, filter: (Fruit) -> Boolean) {
//}
// 이때 타입 얼라이언스 사용
typealias FruitFilter = (Fruit) -> Boolean
fun filterFruits(fruits: List<Fruit>, filter: FruitFilter){}

// 비슷하게...
data class UltraSuperGuardianTribe(val name: String)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

//as import: 어떤 클래스나 함수를 임포트할때 이름을 바꾸는 기능
//import com.lannstark.lec19.a.printHellowWorld as printHelloWorldA
//import com.lannstark.lec19.b.printHellowWorld as printHelloWorldB

// 2. 구조 분해와 componentN 함수

data class Person(val name: String, val age: Int)

// 데이터 클래스가 아닐때는 어떻게? componentN 함수를 직접 구현해야함
class Person2(val name: String, val age: Int) {
    operator fun component1() = name
    operator fun component2() = age
}

// 3. Jump와 Label
// return: 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다.
// break: 가장 가까운 루프가 제거된다.
// continue: 가장 가까운 루프를 다음 step으로 보낸다.
// foreach...

// label: 가급적 사용하지말것

// 4. TakeIf와 TakeUnless
// TakeIf : 주어진 조건을 만족하면 그 값이, 아니면 널이 반홤됨
fun getNumberOrNull(number: Int): Int? {
    return number.takeIf { it > 0 }
}

// TakeUnless: 주어진 조건을 만족하지 않으면 그 값이, 아니면 null을 반환
fun getNegativeNumberOrNull(number: Int): Int? {
    return number.takeUnless { it > 0 }
}

fun main(){
    val person = Person("유광명", 45)
    val (name, age) = person // ??초기화
    // 위 식은 아래와 같다.
//    val name = person.component1()
//    val age = person.component2()

    println("name: $name, age: $age") // 변수에 데이터 클래스의 적절한 값을 부여해주었다.

    // 3. foreach...
    val numbers = listOf(1, 2, 3)
    for (number in numbers){
        println(number)
    }

//    numbers.map { it  + 1}
//        .forEach { println(it) }
// 이보다 변수명을 표시하는 것을 추천
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    // label

    abc@ for (i in 1..100){
        for (j in 1..100){
            if (j == 2){
                break@abc // break후 인근 루프로 가는 것이 아니라 라벨로 이동
            }
            println("$i $j")
        }
    }

}