package com.anonymous.bowlingscore

class ScoreSimulator(val gameLength: Int = 10) {
    var game = Game(emptyList())

    fun addRoll(roll: Int) {
        if (game.frames.count{it.isFinished} == gameLength){
            addBonusRoll(roll)
        } else {
            val lastFrame = game.frames.lastOrNull()
            val frames = if (lastFrame?.isFinished == false) {
                val newLast = Frame(lastFrame.firstRoll, roll)
                game.frames.dropLast(1) + newLast

            } else game.frames + Frame(roll, null)
            game = Game(frames)
        }
    }

    private fun addBonusRoll(roll: Int) {
        game = if (game.bonusRoll1 == null) {
            Game(game.frames, roll)
        } else {
            Game(game.frames, game.bonusRoll1, roll)
        }
    }

}
