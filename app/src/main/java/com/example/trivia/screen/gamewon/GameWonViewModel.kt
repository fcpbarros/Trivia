package com.example.trivia.screen.gamewon

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameWonViewModel(finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //Creating LiveData for eventPlayAgain
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _score.value =
            finalScore //Make sure to initialize score’s value to the finalScore you pass into the view model
        Log.i("ScoreViewModel", "Final score is $score")
    }

    fun onPlayAgain() {
        Log.i("playagain", "teste")
        _eventPlayAgain.value = true

    }

    fun onPlayAgainFinish() {
        _eventPlayAgain.value = false
    }

}