package org.example

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    // ch1 변수
    var number1 = 10L
    val number2: Long = 20L

    println(number2)

    // val은 초기화 하지 않은 것에 한해서 값을 넣어줄수 있음
    val number3: Long // 초기값을 설정하지 않은 경우 타입정의를 해야한다.
    number3 = 10L
    println(number3)

    // val 컬렉션에는 element를 추가할 수 있다.
    // 클린코드 팁: 모든 코드는 불변(val)로 만들고 꼭 필요한 경우 var로 만들어라

    // 코틀린에서 Primitive Type??
    var number4 = 10
    var number5 = 1000L
    // 내부적으로 타입을 변경해서 처리를 해본다.
    println("$number4")
    println("$number5")

    // null 변수: 널이 들어갈 수 있는 .. 의 개념을 표현함
    var number6 = 1_000L
    // number6 = null  // 이렇게 널을 대입하려고 하면 에러 발생
    // 기본적으로 코틀린은 null을 입력하지 못하도록 설계
    // 그러면 대안은?
    // 타입을 정의해야함?로
    var number7: Long? = 1_000L
    number7 = null

    println(number7)

    // 중요 : 널은 아예 다른 타입으로 간주됨
    // 2강에서 계속...
}