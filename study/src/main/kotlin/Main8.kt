package com.lannstark.lec08

// ch8. 코틀린에서 함수를 다루는 방법
//1. 함수 선언 문법
//2. default parameter
// 3. named argument(parameter)
// 4. 같은 타입의 여러 파라미터 받기(가변인자)

//1. 함수 선언 문법
// 두 정수를 받아 더 큰 정수를 반환하는 문제

fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }else
        return b
}

// 개선
fun max2(a: Int, b: Int): Int {
    return if (a > b) { // 전체가 expression
        a
    }else
        b
}
// 그런데 expression은 등호로 표현 가능
fun max3(a: Int, b: Int): Int =
    if (a > b) { // 하나의 expression이므로 등호처리 가능
        a
    }else {
        b
    }

// 타입을 생략하고 중괄호를 생략하고 한줄로 몰수도 있다.
fun max4(a: Int, b: Int) = if (a > b) a else b
// 블럭 {}을 사용하는 경우, 반환 타입이 Unit아니라면 명시적으로 타입을 작성해야함!

// 함수는 클래스 안에 있을수도, 파일 최상단에 있을수도 있다.
// 또한, 한 파일 안에 여러 함수들이 있을수도 있다.

//2. default parameter
// 주어진 문자열을 N번 출력하는 예제
fun repeat(str: String, num: Int= 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

// 3. named arguement ?? 다시 볼것
// 만약 앞의 함수에서 num은 디펄트 3을 그대로 쓰고 싶고, useNewLine은 false를 쓰고 싶다면?
// repeat(str = "Hello World",useNewLine = false)
// 또다른 예
fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}
// 그런데 동일한 타입이니까, 실수할 수도 있고 불편하다.???

// 주의: 코틀린에서 자바 함수를 가져다 사용할 때는 named argument를 사용할 수 없다.

// 4. 같은 타입의 여러 파라미터 받기
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}


fun main(){
    repeat("Hello World", 4, true)
    repeat(str = "Hello World",)
    repeat("Hello World", useNewLine = false)

    printNameAndGender(name = "유광명",gender = "MALE")

    // 코틀린에서 자바함수를 가져다 쓸때는 named argument 불가
    //예시: Lec08Main.repeat("ㅇㄹㄴㄹ", "ㅇㄹㅇ")

    // 4. 같은 타입의 여러 파라미터 받기
    // 실제 사용할때는 배열을 사용하거나 콤파로 구분
    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    printAll(*array) // 스프레드 연산자 *를 사용해야 한다.
}
