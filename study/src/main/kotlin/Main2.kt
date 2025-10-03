package com.lannstark.lec02

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() { // ch2
// 코틀린에서 null을 다루는 방법
    // 1. 코틀린에서 널체크

    //println(startsWithA1(null))
    println(startsWithA1("Abc"))
    println(startsWithA1("aYZ"))
    println(startsWithA2(null))
    println(startsWithA3(null))
    // 결론: 코틀린에서는 널이 가능한 타입을 완전히 다르게 취급한다.


    // 2. Safe call과 엘비스 연산자
    // 그러면 널이 가능한 타입만을 위한 기능은 없나???
    // 첫번째 세이프콜
    val str: String? = null // 널이 들어갈수 있는 변수이다.
    //str.length// 불가능
    val length = str?.length // 가능, 널이 아니면 값 실행, null이면 널 저장
    // 이?.이 세이프 컬이다.
    println(length)

    // 다음은 세이프콜과 함께 실행되는 엘비스 연산자
    val str2: String? = null
    val length2 = str?.length ?:0 // 앞의 연산 결과가 널이면 뒤의 값을 이용
    println(length2)

    // 엘비스 연산자는 null이 발생했을 얼리 리턴 용으로 사용하면 편하다.
//    fun calculate(number: Long?): Long{
//        number ?: return 0
//        return number * 100L
//    }


// 3. 널아님 단언: nullable type 이지만, 아무리 생각해도 null이 될수 없는 경우
    // !!를 사용함
    println(startsWithA4("AAA"))
    //println(startsWithA4(null)) // 널이 안들어올거라고 단언했지만 null이 들어오면 컴파일 에러는 없지만 런타임 에러 발생


    // 4. 플랫폼 타입: 다시 볼것
    // 코틀린에서 자바 코드를 가져다 쓸때
    val person = Person("공부하는 개발자")
//    val personResult = startswithA(person.name)
//    println(personResult) 에러발생
    // 이유는 자바 코드에서 널이 될수 있기 때문

}

fun startsWithA1(str: String?): Boolean{ // 인자로 널이 들어올수 있음을 명시, 따라서 널체크 필요
    if (str == null) {
        throw IllegalArgumentException("null 이 들어왔습니다")
    }
    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean?{ // 이번엔 널이 리턴될수 있는 함수이다.
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean{
    //return str.startsWith("A") // 에러발생, str이 널일수도 있는데 startsWith를 호출할 수 없기 때문이다.

    if (str == null) {
        return false
    }
    return str.startsWith("A") // 똑똑하게도 앞에서 널체크 구문이 있으면 다음 구문에서는 널이 아니라고 판단하고 허용함
}

// 앞의 세 함수를 엘비스 연산자를 사용해서 코틀린 스럽게 작성해보자.
fun startsWithA11(str: String?) : Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("Null이 들어왔습니다.")
}

fun startsWithA22(str: String?) : Boolean? {
    return str?.startsWith("A")
}

fun startsWithA33(str: String?) : Boolean {
    return str?.startsWith("A") ?: false
}

// 이제 널 아님 단언 함수를 만들어보자
fun startsWithA4(str: String?) : Boolean {
    // return str.startsWith("A") // 이렇게 쓰면 에러 발생
    return str!!.startsWith("A") // !!으로 단언하여 정상 구문으로 만듬
}

// 플랫폼 타입 변환 관련 함수
fun startsWithA(str: String) : Boolean {
    return str.startsWith("A")
}