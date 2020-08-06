package com.example.trivia.screen.gamewon

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameWonViewModel(finalScore: Int) : ViewModel() {

    //finalScore: Int
    //Creating LiveData for score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    init {
        _score.value =
            finalScore //Make sure to initialize score’s value to the finalScore you pass into the view model
        Log.i("ScoreViewModel", "Final score is $_score")
    }

}