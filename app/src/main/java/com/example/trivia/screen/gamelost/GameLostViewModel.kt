package com.example.trivia.screen.gamelost

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameLostViewModel(finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //Creating LiveData for eventPlayAgain
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _score.value = finalScore //Make sure to initialize score’s value
        Log.i("ScoreViewModel", "Final score is $score")
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true

    }

    fun onPlayAgainFinish() {
        _eventPlayAgain.value = false
    }

}