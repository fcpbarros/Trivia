package com.example.trivia.screen.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel(finalScore: Int, resultBoolean: Boolean) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _result = MutableLiveData<Boolean>()
    val result: LiveData<Boolean>
        get() = _result

    //Creating LiveData for eventPlayAgain
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _score.value =
            finalScore //Make sure to initialize score’s value to the finalScore you pass into the view model
        checkResult(resultBoolean)

    }

    private fun checkResult(resultBoolean: Boolean) {
        /**
         * In case user loses the game resultBoolean = false
         */
        if (resultBoolean) {
            //User has won the game
            _result.value = resultBoolean
            Log.i("resultGame", "Victory!")
        } else {
            //User has lost the game
            _result.value = resultBoolean
            Log.i("resultGame", "Defeat!")
        }

    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true

    }

    fun onPlayAgainFinish() {
        _eventPlayAgain.value = false
    }

}