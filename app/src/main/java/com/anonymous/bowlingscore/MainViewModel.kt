package com.anonymous.bowlingscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val simulator: ScoreSimulator) : ViewModel() {

    private var mGameState = MutableLiveData<Game>()
    val gameState: LiveData<Game> = mGameState

    fun startNewGame(){
        simulator.game = Game(emptyList())
        mGameState.postValue(simulator.game)
    }
}