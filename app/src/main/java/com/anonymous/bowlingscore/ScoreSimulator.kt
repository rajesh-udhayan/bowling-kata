package com.anonymous.bowlingscore

class ScoreSimulator {
    var game = Game(emptyList())

    fun addRoll(roll: Int) {
        val frames = game.frames + Frame(roll,null)
        game = Game(frames)
    }

}
