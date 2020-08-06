package com.example.trivia.screen.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    /**
     * From now on all the logic of the gameFragment will be done here
     * Here we use LiveData with encapsulation
     */
    private var _currentQuestion = MutableLiveData<GameFragment.Question>()
    val currentQuestion: LiveData<GameFragment.Question>
        get() = _currentQuestion

    private var _answers = MutableLiveData<MutableList<String>>()
    val answers: LiveData<MutableList<String>>
        get() = _answers

    private var _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

}