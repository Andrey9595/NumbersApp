package ru.anb.numbers

import android.graphics.Color
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Numbers(
    val number: Int,
    val color: Int = if (number % 2 == 0) Color.RED else Color.BLUE

): Parcelable



