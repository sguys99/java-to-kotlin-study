package com.lannstark.lec16

import com.lannstark.lec03.printAgeIfPerson3

// 1. 확장함수 : String을 확장해보자.
// fun 확장하려는클래스.함수이름(파라미타): 리턴타입 {this를 이횽해 실제 클래스 안의 값에 접근}
// this를 수신 객체라고 한다.
fun String.lastChar(): Char{
    return this[this.length - 1] // 마지막 문자를 가져옴
}

// 그러면 확장함수가 public이고 확장함수에서 수신객체 클래스의 private 함수를 가져오면 캡슐화가 깨지는거 아닌가?
// 그래서 애당초 확장함수는 클래스에 있는 private, protected 멤버를 가져올 수 없다.

// 멤버함수와 확장함수의 시그니처가 같다면?
// Main16으로 돌아가서 설명

fun main(){
    val str = "ABC"
    println(str.lastChar())
}