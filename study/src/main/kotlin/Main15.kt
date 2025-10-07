package com.lannstark.lec15

// ch15. 코틀린에서 배열과 컬렉션을 다루는 방법
// 1. 배열
// 2. 코틀린에서의 Collection - List, Set, Map
// 3. 컬렉션의 null 가능성, 자바와 함께 사용하기

// 1. 배열
// 사실 배열 잘 사용 안함, 배열보다 리스트를 주로 사용


// 2. 코틀린에서 컬렉션: 불변, 가변 여부를 설정해줘야 함
// 그런데 불변 컬렉션이어도 Reference Type인 Element의 필드는 바꿀수 있다.

// Set: 집합은 List와 다르게 순서가 없고 같은 element는 하나만 존재할 수있다.
// 나머지는 list와 비슷

// 3. 컬렉션의 널 가능성:?
// List<Int?> : 리스트에 널이 들어갈수 있지만 리스트는 널이 아님
// List<Int>? : 리스트에는 널이 들어갈수 없지만 리스트는 널일수 있음
// List<Int?>? : 리스트에는 널이 들어갈수 있고 리스트도 널일수 있음

// 자바는 읽기 전용과 변경 가능 컬렉션을 구분하지 않는다.


fun main() {
    val array = arrayOf(100, 200, 300)

    for (i in array.indices){ // 배열의 마지막 인덱스
        println(array[i])
    }

    // 인덱스와 값을 함께
    for ((index, value) in array.withIndex()){
        println("index: $index, value: $value")
    }

    // 배열에 값 추가하기
    array.plus(400)
    println(array.toList())

    // 2. List
    val numbers = listOf(100, 200, 300)
    val emptyList = emptyList<Int>() // 비어있는 리스트도 만들수 있음. 이때는 예상되는 타입을 명시적으로 적어줘야...
    // 물론 타입 추론이 가능하면 생략가능

    println(numbers.get(0))
    println(numbers[0])

    for (number in numbers){
        println(number)
    }

    for((idx, value) in numbers.withIndex()){
        println("idx: $idx, value: $value")
    }

    // 가변 리스트를 만둘려면?
    val mutableNumbers = mutableListOf(100, 200, 300)
    mutableNumbers.add(400)
    println(mutableNumbers)

    // 간단한 팁: 우선 불변 리스트를 만들고 꼭 필요한 경우 가변으로 변경하자.

    // set
    val numbersSet = setOf(100, 200, 300)
    println(numbersSet)
    // map
    val oldMap = mutableMapOf<Int, String>()
    oldMap.put(1, "Monday")
    oldMap[2] = "Tuesday"
    println(oldMap)
    val newMap = mapOf(1 to "Monday", 2 to "Tuesday")
    println(newMap)

    for (key in oldMap.keys ){
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries){
        println("key: $key, value: $value")
    }

}
