package com.lannstark.lec09

// ch9. 코틀린에서 클래스를 다루는 방법
// 1. 클래스와 프로퍼티
// 2. 생성자와 init
// 3. 커스텀 getter, setter
// 4. backing field

public class PersonOld constructor(name: String, age: Int){// 디펄트 public 이므로 생략 가능
    val name = name // 불변
    var age = age

    // 프로퍼티 = 필드 + getter + setter
    // 코틀리에서는 필드만 만들면 getter, setter를 자동으로 만들어 준다.

}

// 컨스트럭터라는 지시어도 생략가능
// 그리고 생성자에서 바로 프로퍼티를 만들어 줄수 있다.
// 정리하면
public class Person(val name: String, var age: Int)
// 간결해졌다.
// 그리고 .통해 불러올 수 있다.

// 2. 나이를 검증하는 로직을 추가하려면? init 사용
public class Person2(val name: String, var age: Int){ // 주 생성자(primary constructor): 반드시 있어야 한다.
    init{ // init는 처음 생성될 때 호출되는 로직이다. 여기에 검증로직 추가 가능
        if(age<=0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }
    // 생성자를 추가하려면?? 다시 볼것
    // 앞에 것은 그대로 두고 아래에 추가 가능
    constructor(name: String) : this(name, 1) // 부생성자: 있어도 되고 없어도 되고. . 호출된 후 그 전에 생성자를 호출함

    constructor(): this("홍길동") { // 이것이 호출되고, 그다음 위의 constructor를 호출한다.
        println("두번째 부생성자") // 부생성자는 바디를 가질수도 있다.
    }
}
// 즉, 초기화블록 -> 첫벗째 부생성자 -> 두번째 부생성자 순으로 실행..???

// 그런데 사실, 코틀린에서는 부생성자 보다 default parameter를 권장함!!!!
// 부생성자는 거의 쓸일이 없다.
class Person3(
    val name: String = "유광명",
    var age: Int = 1
){
    init{
        if(age < 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }
}

// 3. 커스텀 getter, setter
class Person4(
    val name: String = "유광명",
    var age: Int = 1
){
    init{
        if(age < 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블럭")
    }

    fun isAdult(): Boolean{
        return age >= 20
    }

    // 위를  아래와 같이 커스텀 getter로 구현 가능
    val isAdult1: Boolean
        get() = age >= 20

    // 즉, 함수로 만드는 방법, 프로퍼티로 만드는 방법 세가지가 존재(아래 포함)
    val isAdult2: Boolean
        get() {
            return age >= 20
        }
}

// 4. backing field: 다시 볼것, backing field를 사용하는 경우는 드물었다.???
// custom setter도 잘 안쓴다....

fun main() {
    var person = Person("유광명",45)
    println(person.name)
    person.age = 46
    println(person.age)

    // 코틀린에서 자바클래스를 가져다 쓸때도 . 사용 가능!!!
    var javaPerson = JavaPerson("유광명", 45)
    println(javaPerson.name)
    println(javaPerson.age)

    // 추가 생성자
    var person2 = Person2("유광명")
    println(person2.age)
    var person3 = Person2()
    println(person3.name)
}