package ru.netology

const val secondsInMinute = 60
const val secondsInHour = secondsInMinute * secondsInMinute
const val second = 1
const val day = 24 * secondsInHour

fun main() {
    val lastVisitSecondsAgo = 9843
    agoToText(lastVisitSecondsAgo)
}

fun agoToText(seconds: Int) {
    var minutesForm : String
    var hoursForm : String
    when  {
        seconds in 1..<secondsInMinute -> println("был(а) только что")
        seconds in secondsInMinute + second..secondsInHour -> {
            minutesForm = chooseCorrectMinutesForm(seconds)
            println("был(а) ${seconds / secondsInMinute} $minutesForm назад")
        }
        seconds in secondsInHour + second .. day -> {
            hoursForm = chooseCorrectHoursForm(seconds)
            println("был(а) ${seconds / secondsInHour} $hoursForm назад")
        }
        seconds in day + second .. 2 * day -> println("был(а) вчера")
        seconds in 2 * day + second .. 3 * day -> println("был(а) позавчера")
        seconds >= 3 * day + second -> println("был(а) давно")
    }
}

fun chooseCorrectMinutesForm(seconds : Int) : String {
    val minutes = seconds / secondsInMinute
    return when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 32, 42, 52, 23, 33, 43, 53, 24, 34, 44, 54 -> "минуты"
        else -> "минут"
    }
}

fun chooseCorrectHoursForm(seconds : Int) : String {
    val hours = seconds / (secondsInHour)
    return when (hours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}