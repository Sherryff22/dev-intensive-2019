package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}


fun Date.humanizeDiff(): String {
    return humanizeDiff2(this)
}

fun humanizeDiff2(date: Date = Date()): String {
    val timeDiff: Long
    val timeNow: Long = Date().time
    timeDiff = (date.time - timeNow) / 1000

    return when (timeDiff) {
        in 0..1 ->"только что"
        in 1..45 -> "несколько секунд назад"
        in 45..75 -> "минуту назад"
        in 75..2700 ->
            when {
                timeDiff  < 120 -> ((timeDiff / 60).toString() + " минуту назад")
                timeDiff  < 300 -> ((timeDiff / 60).toString() + " минуты назад")
                else -> ((timeDiff / 60).toString() + " минут назад")
            }
        in 2700..4500 -> "час назад"
        in 4500..79200 ->
            when {
                timeDiff < 7200 -> ((timeDiff / 3600).toString() + " час назад")
                timeDiff < 18000 -> ((timeDiff / 3600).toString() + " часа назад")
                else -> ((timeDiff / 3600).toString() + " часов назад")
            }
        in 79200..93600 -> "день назад"
        in 93600..31104000 ->
            when {
                timeDiff < 172800 -> ((timeDiff / 86400).toString() + " день назад")
                timeDiff < 432000 -> ((timeDiff / 86400).toString() + " дня назад")
                else -> ((timeDiff / 86400).toString() + " дней назад")
            }
        else -> "более года назад"
    }.toString()
}


enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

