package com.lannstark.lec07
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

// ch 7. 코틀린에서 예외를 다루는 방법

// 1. try catch finally
// 2. checked exception과 unchecked exception
// 3. try with resources

// 1. try catch finally
fun parseIntOrThrow(str: String): Int{
    try{
        return str.toInt()
    } catch (e: NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
}

// 여기에 실패하는 널을 반환하도록 수정해보자.
fun parseIntOrThrow2(str: String): Int?{
    try{
        return str.toInt()
    } catch (e: NumberFormatException){
        return null
    }
}
// 더 개선
fun parseIntOrThrow3(str: String): Int?{
    return try{
        str.toInt()
    } catch (e: NumberFormatException){
        null
    }
}

// try catch finally는 직접 해볼것

// 2. checked exception과 unchecked exception

class FilePrinter{ // 다시 볼것
    fun readFile() {
        val currentFile = File(".")// 현재경로
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }
}
// 코틀린에서는 Checked Exception과 Unchecked Exception을 구분하지 않음. 모두 unchecked exception
// 그래서 throw를 붙여주지 않았지만 빨간줄이 나타나지 않음

// 3. try with resources // 코틀린에서는 try with resources가 사라졌다. 없다. use를 사용한다.???
// 앞과 같은 예제인데, 경로를 읽어오는 예제이다.

class FilePrinter2{
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}

fun main(){
    val filePrinter = FilePrinter()
    filePrinter.readFile()

    val filePrinter2 = FilePrinter2()
    filePrinter2.readFile("a.txt")
}

