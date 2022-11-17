package com.anonymous.bowlingscore

data class Game(
    val frames: List<Frame>,
    val bonusRoll1: Int? = null
) {

}