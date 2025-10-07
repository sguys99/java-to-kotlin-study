package com.lannstark.lec10

// 10.1 애니멀 클래스
abstract class Animal(
    protected val species: String, // protected????
    protected open val legCount: Int, // open 붙이는 이유: property를 오버라이드 하려면 open을 붙여줘야....
) {
    abstract fun move()
}