package com.lannstark.lec05
// 1. if
// 2. Expression, statement
// 3. switch, when

// 1. if
fun validateScoreIsNotNegative(score: Int) { // Unint(void)가 생략됨
    if (score < 0){
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

// else가 있는 경우
fun getPassOrFail(score: Int): String{
    if (score >= 50){
        return "P"
    } else{
        return "F"
    }
}
// 자바에서 if-else는 Statement이지만 코틀린에서는 Expression이다.
// Statement: 프로그램의 문장, 하나의 값으로 도출되지 않는다.
// Expression: 하나의 값으로 도출되는 문장
// 즉 코틀린에서는 if-else 문은 한번에 리턴 가능 // 중요

// if, if-else
fun getGrade(score: Int): String{
    return if (score >= 90){
        return "A"
    } else if (score >= 80){
        return "B"
    } else if (score >= 70){
        return "C"
    } else{
        return "D"
    }
}

// 값이 어떤 범위에 있는지 표현할 때 -> in .. 사용하면 편하다.
// 앞의 함수를 수정해보자.
fun validateScoreIsNotNegative2(score: Int) { // Unint(void)가 생략됨
    if (score !in 0..100){
        throw IllegalArgumentException("score의 범위는 0부터 100입니다.")
    }
}

// 3. switch, when
fun getGrateWithSwitch(score: Int): String{
    return when(score){ //when도 expression이므로 리턴 가능: 조건부에는 어떠한 expression도 들어갈수있다.
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any) : Boolean {
    return when(obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int){
    when(number){
        1, 0, -1 -> println("어디서 많이본 숫자입니다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

// 위 함수는 when뒤에 조건을 없이 구현할 수도 있다.
fun judgeNumber2(number: Int){
    when{
        number == 0 -> println("주어진 숫자는 0입니다.")
        number %2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}

fun main() {

}