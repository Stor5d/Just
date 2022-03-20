package ru.netology

fun main() {
    val seconds: Array<Int> =
        arrayOf(40, 60, 120, 300, 660, 1260, 3600, 7200, 18000, 39600, 75600, 86400, 172800, 259200)
    for (second in seconds) {
        val text = agoToText(second)
        println(text)
    }
}

fun agoToText(second: Int): String {
    val text = "был(а)"
    return when {
        second < 60 -> "$text только что"
        second >= 60 && second < 60 * 60 -> "$text ${minutesConversion(second)}"
        second >= 60 * 60 && second < 60 * 60 * 24 -> "$text ${hourConversion(second)}"
        second >= 60 * 60 * 24 && second < 60 * 60 * 24 * 2 -> "$text сегодня"
        second >= 60 * 60 * 24 * 2 && second < 60 * 60 * 24 * 3 -> "$text вчера"
        else -> "$text давно"
    }
}

fun minutesConversion(second: Int): String {
    val minutes: Int = second / 60
    return when {
        minutes % 10 == 0 || (minutes % 10 in 5..9) || (minutes in 11..19) -> "$minutes минут назад"
        minutes % 10 == 1 -> "$minutes минуту назад"
        else -> "$minutes минуты назад"
    }
}

fun hourConversion(second: Int): String {
    val hour: Int = second / 3600
    return when {
        hour % 10 == 0 || (hour % 10 in 5..9) || (hour in 11..19) -> "$hour часов назад"
        hour % 10 == 1 -> "$hour час назад"
        else -> "$hour часа назад"
    }
}