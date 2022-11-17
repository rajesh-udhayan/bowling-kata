package com.anonymous.bowlingscore

class ScoreSimulator {
    var game = Game(emptyList())

    fun addRoll(roll: Int) {
        val lastFrame = game.frames.lastOrNull()
        val frames = if (lastFrame?.isFinished == false) {
            val newLast = Frame(lastFrame.firstRoll, roll)
            game.frames.dropLast(1) + newLast

        } else game.frames + Frame(roll, null)
        game = Game(frames)
    }

}
