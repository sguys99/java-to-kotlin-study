package com.lannstark.lec10

// ch10. 코틀린에서 상속을 다루는 방법
// 1. 추상클래스
// 2. 인터페이스
// 3. 클래스를 상속할 때 주의할 점
// 4. 상속관련 지시어 정리

// 1. 추상클래스
// Animal이란 추상 클래스를 구현한 Cat, Penguin

// 2. 인터페이스
// 펭귄 볼것

// 3. 클래스를 상속할 때 주의할 점
// Base, Derived클래스를 만들고 Derived 인스턴스를 생성되면 어떻게 호출되는지 보자.

open class Base(
    open val number: Int=100
){
    init {
        println("Base class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number){
    init {
        println("Derived class")
    }
}

fun main(){
    Derived(300)
    // 실행하면 number에 0이 출력된다....
    // 상위클래스 number 호출하는 동안 하위 클래스에서 초기화 되지 않았는데,, 출력하게 되어 0이 나온다..
    // 따라서 하위 클래스에서 오버라이드 하고 있는 것을 상위에서 호출하면 안된다.
    // 따라서 open을 사용하면 안된다.
}

// 4. 상속관련 키워드 4가지 정리
// 1) final: Override를 할수 없게 한다. default로 보이지 않게 존재한다.
// 2) open: override를 열어준다.
// 3) abstract: 반드시 override해야한다.
// 4) override: 상위 타입을 오버라이드 하고 있다.