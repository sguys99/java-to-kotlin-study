package com.lannstark.lec06

// 1. for-each
// 2. for
// 3. Progression과 Range
// 4. while

fun main() {

    // 1. for-each
    val numbers = listOf(1L, 2L, 3L)

    for (number in numbers){
        println(number)
    }

    // 2. for
    for (i in 1..3){
        println(i)
    }
    // 내려가는 경우
    for (i in 3 downTo 1){
        println(i)
    }
    // 두칸씩 올라가는 경우
    for (i in 1..10 step 2){
        println(i)
    }

    // 4. while
    var i = 1
    while (i <= 3){
        println(i)
        i++
    }

}



