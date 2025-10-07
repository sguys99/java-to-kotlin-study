package com.lannstark.lec17

// ch 17. 코틀린에서 람다를 다루는 방법
// 1. 자바에서 람다를 다루는 노력
// 2. 코틀린에서의 람다
// 3. Closure
// 4. try with resources

// 1.
//2. 코틀린에서의 람다
// 자바와 근본적으로 다른 한가지가 있음
// 코틀린에서는 함수가 그 자체로 값이 될 수 있다. // 자바는 불가
// 변수에 할당할수도, 파라미터로 넘길수도 있다.
// 이제 익명함수를 변수에 넣어보자.

//3. 클로져: 다시 볼것...

// 4. try with resources: 다시 볼것

fun main() {
    val fruit = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )

    // 람다함수 방법 1
    val isApple = fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    }

    // 두번째 방법: 더 간결
    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    // 이 람다 변수는 저장되는 함수의 타입을 지정할 수도 있다. // (파라미터 타입...) -> 반환 타입
    val isApple3: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    }

    val isApple4: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}

    // 사용방법 1
    println(isApple(fruit[0]))

    // 사용방법 2
    println(isApple.invoke(fruit[0]))


    // filterFruit 사용해보기
    println(filterFruits(fruit, isApple))
    // 더 간결하개 가능... 생량... 다시볼것.. 중요

}


// 이제 자바에 구현되어 있는 filterFruits를 옮겨서 구현해보자.
// ?? 다시 볼것
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit>{
    val result = mutableListOf<Fruit>()
    for (fruit in fruits){
        if (filter(fruit)){
            result.add(fruit)
        }
    }
    return result
}
// 코틀린은 함수를 1급 시민으로 간주...
// 람다는 리턴을 쓰지 않아도 마지막 줄이 리턴 값임


