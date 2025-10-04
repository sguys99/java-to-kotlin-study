package com.lannstark.lec04

// ch4 코틀린에서 연산자를 다루는 방법
//1. 단항 연산자/ 산술 연산자
//2. 비교 연산자와 동등성, 동일성
// 3. 논리연산자/ 코틀린에 있는 특이한 연산자
// 4. 연산자 오버로딩

fun main() {
    // 2. 비교연산자
    // 그중에서도 객체를 비교하는 부분을 보자.
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2){
        println("money1이 money2보다 큽니다.")
    }
    // 동등성(equality): 두 객체의 값이 같은가, == 사용
    // 동일성(Identity) 완전히 동일한 객체인가. 즉 주소가 같은가, === 사용
    val money3 = JavaMoney(2_000L)
    val money4 = money1
    println(money1 == money3) // false
    println(money1 === money3)
    println(money1 === money4)

    // 3. 코틀린에 있는 특이한 연산자
    // in / !in : 컬렉션이나 범위에 포함되어 있다. 포함되어 있지 않다
    // a..b : a부터 b까지의 범위 객체를 생성한다.
    // a[i]
    // a[i] = b

    // 4. 연산자 오버로딩
    val money5 = JavaMoney(2_000L)
    val money6 = JavaMoney(1_000L)

    println(money5 + money6) // + 연산자를 사용하여 연산 가능
    // 즉 코틀린에서는 객체마다 연산자를 직접 정의할 수 있다.

}