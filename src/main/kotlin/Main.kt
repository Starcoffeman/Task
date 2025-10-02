package org.example

import java.util.*

fun sumInRange(n: Int): Int {
    var sum: Int = 0
    for (i in 1..n) {
        sum += i
    }
    return sum;
}

fun findMax(numbers: List<Int>): Int {
    return numbers.max()
}

fun countVowels(text: String): Int {
    val vowels = listOf('а', 'у', 'е', 'о', 'ы', 'я', 'и', 'ю')
    var vowel: Int = 0
    for (i in text) {
        if (vowels.contains(i)) {
            vowel++
        }
    }
    return vowel
}

fun isPalindrome(text: String): Boolean {
    return text.trim().lowercase(Locale.getDefault()) == text.trim().lowercase(Locale.getDefault()).reversed()
}

fun filterEvenNumbers(numbers: List<Int>): List<Int> {
    val even = ArrayList<Int>()
    for (i in numbers) {
        if (i % 2 == 0) even.add(i) else continue
    }
    return even
}

fun celsiusToFahrenheit(celsius: Double): Double {
    return (celsius * 9 / 5) + 32
}

fun printMultiplicationTable(n: Int): Unit {
    println("Таблица")
    for (i in 1..10) {
        val res = n * i
        println("$i * $n = $res")
    }
}

fun findPrimesUpTo(n: Int): List<Int> {
    val l = mutableListOf<Int>()
    for (i in 2..n) {
        val del = ArrayList<Int>()
        for (j in 1..i) {
            if (i % j == 0) {
                del.add(j)
            }
        }
        if (del.size == 2) {
            l.add(i)
        }
    }
    return l
}

fun countWords(text: String): Int {
    return text.trim().split(" ").size
}

fun charFrequency(text: String): Map<Char, Int> {
    val bukvy = mutableMapOf<Char, Int>()
    text.lowercase(Locale.getDefault()).forEach { char ->
        bukvy[char] = bukvy.getOrDefault(char, 0) + 1
    }
    bukvy.remove(' ')
    return bukvy
}

fun reverseString(text: String): String {
    return text.reversed()
}

fun findMissingNumber(numbers: List<Int>): Int {
    val n = numbers.size + 1
    val expectedSum = n * (n + 1) / 2
    val actualSum = numbers.sum()
    return expectedSum - actualSum
}

fun areAnagrams(text1: String, text2: String): Boolean {
    if (text1.length != text2.length) return false
    return text1.lowercase(Locale.getDefault()).toCharArray().sorted() == text2.lowercase(Locale.getDefault())
        .toCharArray().sorted()
}

fun sumOfDigits(number: Int): Int {
    var sum = 0;
    var temp = number;
    while (temp != 0) {
        val digit = temp % 10
        sum += digit
        temp /= 10
    }
    return sum;
}

fun fibonacci(n: Int): Int {
    if (n <= 1) return n
    var a = 0
    var b = 1
    for (i in 2..n) {
        val sum = a + b
        a = b
        b = sum
    }
    return b
}

fun findDuplicates(numbers: List<Int>): List<Int> {
    val dupl = ArrayList<Int>()
    for (i in numbers) {
        var a: Int = 0
        for (j in numbers) {
            if (i == j) {
                a++
            }
        }
        if (a >= 2) {
            dupl.add(i)
        }
    }
    return dupl.distinct()
}

fun formatTime(seconds: Int): String {
    val hh = seconds / 3600
    val mm = (seconds % 3600) / 60
    val ss = seconds % 60
    return String.format("%02d:%02d:%02d", hh, mm, ss)
}

fun isPerfectNumber(n: Int): Boolean {
    if (n <= 1) return false

    var sum = 1
    var i = 2
    while (i * i <= n) {
        if (n % i == 0) {
            sum += i
            if (i != n / i) {
                sum += n / i
            }
        }
        i++
    }
    return sum == n
}

fun isValidEmail(email: String): Boolean {
    val pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+\\.([A-Za-z]{2,}|[A-Za-z]{2,}\\.[A-Za-z]{2,})\$".toRegex()
    return pattern.matches(email)
}

fun main() {
    println("Сумма чисел от 1 до N = " + sumInRange(5))
    println("Mакс число: " + findMax(listOf(12, 2, 565, 33, 1)))
    println("Количество гласных букв в строке \"Россия\": " + countVowels("Россия"))
    println("Слово \"Ура\" полиндром: " + isPalindrome("\tУра"))
    println("Список только с четными числами: " + filterEvenNumbers(listOf(12, 2, 565, 33, 1, 3, 2, 4)))
    println("Конвертируемые градусы Цельсия в Фаренгейты: " + celsiusToFahrenheit(10.9))
    println("Таблица умножения для числа 5" + printMultiplicationTable(5))
    println("Список простых чисел до 20: " + findPrimesUpTo(20))
    println("Частота символов в строке: " + charFrequency("Пам пам ууу"))
    println("Перевернутая строка \"QWEQWE\": " + reverseString("QWEQWE"))
    println(
        "В массиве от 1 до 15 одно число пропущено: " + findMissingNumber(
            listOf(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                12,
                13,
                14,
                15
            )
        )
    )
    println("Две строки анаграммы: " + areAnagrams("Рано", "Нора"))
    println("Сумма цифр заданного числа: " + sumOfDigits(213))
    println("Числа Фибоначчи до 30 " + fibonacci(30))
    println("Дублирующиеся элементы в списке" + findDuplicates(listOf(11, 11, 1, 1, 3213, 341, 4454, 123132, 6765)))
    println("Конвертируй секунды в формат \"ЧЧ:ММ:СС\"" + formatTime(11111))
    println("Является ли число совершенным: " + isPerfectNumber(26))
    println("Является ли строка валидным email: " + isValidEmail("227107@edu.fa.ru"))
}