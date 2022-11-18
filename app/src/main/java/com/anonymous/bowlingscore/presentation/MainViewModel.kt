package com.anonymous.bowlingscore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anonymous.bowlingscore.domain.ScoreCalculator
import com.anonymous.bowlingscore.domain.ScoreParser
import com.anonymous.bowlingscore.domain.ScoreSimulator
import com.anonymous.bowlingscore.model.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    val simulator: ScoreSimulator,
    val parser: ScoreParser,
    val calculator: ScoreCalculator
) : ViewModel() {

    private var mGameState = MutableLiveData<Game>()
    val gameState: LiveData<Game> = mGameState

    private val random = Random

    fun addRoll(){
        simulator.addRoll(random.nextInt(simulator.pinsRemaining + 1))
        mGameState.postValue(simulator.game)
    }

    fun startNewGame(){
        simulator.game = Game(emptyList())
        mGameState.postValue(simulator.game)
    }

    fun parseScore(frameIndex: Int, game: Game): String{
        return if (frameIndex == GAME_LENGTH - 1){
            parser.getRepresentation(game.frames.getOrNull(frameIndex), game.bonusRoll1, game.bonusRoll2)
        } else {
            parser.getRepresentation(game.frames.getOrNull(frameIndex))
        }
    }

    fun getFrameScore(frameIndex: Int, game: Game): Int? = calculator.getFrameScore(game, frameIndex)

    fun getGameScore(game: Game): Int = calculator.getGameScore(game)
}