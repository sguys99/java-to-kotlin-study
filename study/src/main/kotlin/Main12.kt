package com.lannstark.lec12

// ch12. 코틀린에서 object 키워드를 다루는 방법
// 1. static 함수와 변수
// 2. 싱글톤
// 3. 익명 클래스

// 1. static 함수와 변수

class Person private constructor(
    var name: String,
    var age: Int,
){
    // 코틀린은 static이 없다. 그래서
    companion object{
        private const val MIN_AGE = 1 // const를 안붙이면 런타임이 아니라 컴파일시에 할당된다.
        // 다시 말해 const는 진짜 상수에 붙이기 위한 용도. 기본 타입과 String에 붙일 수 있다.
        fun newBaby(name: String): Person{
            return Person(name, MIN_AGE)
        }
    }
}
// static: 클래스가 인스턴스화 될때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유
// companion object: 클래스와 동행하는 유일한 오브젝트
// 그런데 companion object, 즉 동반 객체도 하나의 객체로 간주된다.
// 때문에 이름을 붙일수도 있고, interface를 구현할 수도 있다.


class Person2 private constructor(
    var name: String,
    var age: Int,
){
    companion object Factory : Log{ // 컴패니언 오브젝트에 이름을 지어줬다. 그리고 인터페이스도 추가해줬다.
        private const val MIN_AGE = 1
        fun newBaby(name: String): Person2{
            return Person2(name, MIN_AGE)
        }
        override fun log() { // 인터페이스의 추상메서드도 구현해줬다.
            println("나는 Person2 클래스의 동행객채이다.")
        }
    }
}

// 2. 싱글톤 : 단하나의 인스턴스만을 갖는 클래스
// 코틀린에서는 object 키워드를 사용하면 된다.
object Singleton {
    var a: Int = 0
}

// 3. 익명 클래스 : 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스???
private fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}

fun main() {
    println(Singleton.a)// 싱글턴에 접근하는 방법
    Singleton.a += 10
    println(Singleton.a)

    // 익명 클래스
    moveSomething(object : Movable{ // 코틀린에서는 object : 타입 이름으로 익명 클래스를 표현
        override fun move() {
            println("move move")
        }
        override fun fly() {
            println("fly fly")
        }
    })

}
