package com.anonymous.bowlingscore

class ScoreSimulator(val gameLength: Int = 10) {
    var game = Game(emptyList())

    fun addRoll(roll: Int) {
        if (game.frames.count{it.isFinished} == gameLength){
            if(game.bonusRoll1 == null) {
                game = Game(game.frames, roll)
            } else {
                game = Game(game.frames, game.bonusRoll1, roll)
            }
        } else {
            val lastFrame = game.frames.lastOrNull()
            val frames = if (lastFrame?.isFinished == false) {
                val newLast = Frame(lastFrame.firstRoll, roll)
                game.frames.dropLast(1) + newLast

            } else game.frames + Frame(roll, null)
            game = Game(frames)
        }
    }

}
