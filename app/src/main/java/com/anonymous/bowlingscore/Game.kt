package com.anonymous.bowlingscore

data class Game(
    val frames: List<Frame>,
    val bonusRoll1: Int? = null,
    val bonusRoll2: Int? = null
) {

}