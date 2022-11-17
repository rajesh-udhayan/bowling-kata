package com.anonymous.bowlingscore

data class Game(
    val frames: List<Frame>,
    val bonusRoll1: Int? = null,
    val bonusRoll2: Int? = null
) {

    private fun rollsFollowing(frameNumber: Int): List<Int> {
        val remainingRolls = frames.drop(frameNumber + 1).flatMap { listOf(it.firstRoll, it.secondRoll) }
        return (remainingRolls + bonusRoll1 + bonusRoll2).filterNotNull()
    }

    fun getBonusRolls(frameNumber: Int): Pair<Int?, Int?> {
        val frame = frames[frameNumber]
        val rollsFollowing = rollsFollowing(frameNumber)
        val nextRoll = rollsFollowing.getOrNull(0)
        val secondNextRoll = rollsFollowing.getOrNull(1)
        return Pair(
            nextRoll.takeIf { frame.let { it.isSpare || it.isStrike } },
            secondNextRoll?.takeIf { frame.isStrike }
        )
    }

}