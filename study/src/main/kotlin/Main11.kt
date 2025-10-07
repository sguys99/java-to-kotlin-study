package com.lannstark.lec11

// ch11 코틀린에서 접근 제어를 다루는 방법
// 1. 자바와 코틀린의 가시성 제어
// 2. 코틀린 파일의 접근 제어
// 3. 다양한 구성요소의 접근제어
// 4. 자바와 코틀린을 함께 사용할 경우 주의할 점

// 1. 코틀린의 접근 제어
// public: 모든 곳에서 접근 가능
// protected: 선언된 클래스 또는 하위 클래스에서만 접근 가능
// iternal: 같은 모듈에서만 접근가능
// private: 선언된 클래스 내에서만 접근 가능

// 2. 코틀린 파일의 접근제어
// 코틀린의 기본 지시어는 public
// 코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들수 있다.
public val g = 3
public fun add(a: Int, b: Int): Int {
    return a + b
}
public class Cat()
// 위처럼 파일안에 여러개를 만들수 있다.

// public은 기본값으로 어디서든 접근할 수 있다.
// protected는 파일(최상단)에는 사용 불가능 // 클래스에서만 사용가능
// internal 같은 모듈에서만 접근 가능
// private는 같은 파일 내에서만 접근 가능하다.

// 3. 다양한 구성요소의 접근 제어 - 클래스 안의 멤버
// public은 모든 곳에서 접근 가능
// protected는 선언된 클래스 또는 하위 클래스에만 접근 가능
// internal 같은 모듈에서만 접근 가능
// private는 선언된 클래스 내에서만 접근 가능하다.

// 3. 다양한 구성요소의 접근 제어 -생성자
// 가시성 범위는 앞과 동일하다.
// 생성자에 접근 지시어를 붙이려면 constructor를 반드시 써줘야한다!!!
class Cat2 private constructor(val name: String) // 앞에서는 public constructor가 생략된 것이다.

// 3. 다양한 구성요소의 접근 제어 - 프로퍼티
// 앞의케이스와 동일하다.
// 그런데 붙이는 방법이 두가지가 있다.
// internal val name: String....로 getter, setter에 한번에 부여하는 방법
// 커스텀으로 부야하는 방법
class Car( // 3개의 getter(name, owner, price), 2개의 setter가(owner, price) 있는것이다.
    val name: String,
    var owner: String,
    _price: Int,
){
    var price: Int = _price
}
// 이제 접근 제한을 해보자
class Car2(
    internal val name: String,
    private var owner: String,
    _price: Int,
){
    var price: Int = _price
    private set // setter에만 추가로 가시성을 부여함(??? 다시 불것)
}

// 4. 자바 코틀린을 사용할 때 주의할점
// internal은 바이트 코드상 퍼블릭이 된다. 때문에 java 코드에서는 코틀린 모듈의 internal 코드를 가져올 수 있다.
// 양쪽의 protect는 다르다. 자바는 같은 패키지 코틀린의 protected에 접근할 수 있다.

