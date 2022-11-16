package com.anonymous.bowlingscore

data class Frame(
    val firstRoll: Int,
    val secondRoll: Int?
){
    val isSpare = firstRoll + (secondRoll ?: 0) == 10
}
