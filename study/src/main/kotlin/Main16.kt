package com.lannstark.lec16

// ch16. 코틀린에서 다양한 함수를 다루는 방법
// 1. 확장함수
// 2. infix 함수
// 3. inline 함수
// 4. 지역 함수

// 1. 확장함수: 기존 자바코드에 코틀린 코드를 추가해서 유지보수하려면, 클래스 외부에 있으면서 멤버함수 처럼 동작하도록 하는 케이스 필요
// StringUtils.kt 파일로 가서 보자.

// 다시 돌아와서
// 멤버함수와 확장함수의 시그니처가 같다면?
fun Person.nextYearAge(): Int { // 자바에 정의된 클래스에 nextYearAge가 있음, 그런데 또 정의
    println("확장 함수, extension function")
    return this.age + 1
}

// 확장함수가 오버라이드 된다면?
// 다시 볼것...

// 확장함수는 확장 프로퍼티 개념까지 확장됨

// 2. infix 함수: 중위함수, 함수를 호출하는 새로운 방법
// downTo, step도 함수이다.
// 변수.함수 이름(argument) 대신
// 변수 함수이름 argument
fun Int.add(other: Int): Int{
    return this + other
}

infix fun Int.add2(other: Int): Int{
    return this + other
}

// 3. inline 함수: 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 붙여넣고 싶은 경우
// 장점: 함수를 파라미터로 전달할 때에 오버헤드를 줄일수 있다. 하지만 신중하게 사용해야
inline fun Int.add3(other: Int): Int{
    return this + other
}

// 4. 지역함수: 함수안에 함수 선언, 하지만 뎁스가 깊어지고 코드가 깔끔해지지 않는다...., 잘 안씀...

fun main(){
    val person = Person("A", "B", 100)

    person.nextYearAge() // 확장함수가 아니라 멤버함수가 호출됨
    // 시그니처가 동일하면 멤버함수가 우선 호출됨

    // infix 함수
    println(3.add(4))
    println(3.add2(4))
    println(3 add2 4)


}