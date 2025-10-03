package com.lannstark.lec03

// 3. 코틀린에서 type을 다루는 방법
// 1. 기본타입
// 2. 타입 캐스팅
// 3. 코틀린의 3가지 특이한 타입
// 4. String Interpolation, String indexing


fun main() {
    // 1. 기본타입
    // 코틀린은 선언된 기본 값을 보고 타입을 추론한다.
    val number1 = 3 // Int
    val number2 = 3L // Long

    val number3 = 3.0f // Float
    val number4 = 3.0 // Double

    // 자바에서 기본 타입관 변환은 암시적, 코틀린에서는 명시적
    val intNumber = 4
    // val longNumber: Long = number1 // type mismatch
    val longNumber = intNumber.toLong() // to 변환 타입 함수 사용

    // 정수/ 정수 연산에서 실수 결과를 얻고 싶다면
    val number5 = 5
    val number6 = 3
    val result : Long = number5 / number6.toLong()
    println(result) //???

    // 2. 타입 캐스팅
    // 기본 타입 외의 변환은 어떻게 할까
    // 아래 함수 볼것...

    // 만약 널이 들어올수 있다면??
    printAgeIfPerson3(null)

    // 3. 코틀린의 특이한 타입 3가지
    // 3-1 Any
    // 자바의 object 역할(모든 객체의 최상위 타입)
    // 모든 primitive type의 최상위 타입도 any이다.
    // Any 자체로는 null을 포함할수 없어, null을 포함하고 싶다면 Any?로 표현
    // Any에 equals/ hasCode/ toString 존재

    // 3-2 Unit
    // Java의 void와 동일한 역할
    // void와 다르게 타입 인자로 사용가능
    // 함수형 프로그래밍에서 unit는 단하나의 인스턴스만 갖는 타입을 의미. 즉 코틀린의 unit은 실제 존재하는 타입이란걸 표현


    // 3-3 Nothing
    // 함수가 정상적으로 끝나지 않았다는 것을 표현
    // 무조건 예회를 반환하는 함수/ 무한 루프등

    // 3-4 변수
    val person = Person("jinseong", 20)
    println("이름 : ${person.name}")

    // 4.String
    // interpolation
    val name = "KMYU"
    val str ="""
        ABC
        EFG
        ${name}
    """.trimIndent() // 인덴트를 제거해주는 역할

    println(str)

    // indexing
    val str2 = "ABCDE"
    println(str2[0])
    println(str2[2])
}

// 타입 캐스팅 관련 함수
fun printAgeIfPerson(obj: Any){
    if(obj is Person){
        val person = obj as Person // obj를 Person으로 간주하여 넣는다는 의미

        println(person.age)
    }
}

// 다음 처럼 as Person 구문 생략 가능하다.
fun printAgeIfPerson2(obj: Any){
    if(obj is Person){
        println(obj.age) // 이 obj를 스마트 캐스트라고 한다.
    }
}

// Person이 아닐때 도 구현가능

    //if(!(obj is Person))
// if(obj !is Person)
// 위 둘다 같다.


// 만약 obj에 널이 들어올 수 있다면
fun printAgeIfPerson3(obj: Any?){
//    val person = obj as Person
//    println(person.age) // null이 들어왔을 때 런타임 에러가 발생한다.

    val person = obj as? Person
    println(person?.age) // 널이 입력되면 세이프콜에 의해서 null이 출력될 것이다.
}