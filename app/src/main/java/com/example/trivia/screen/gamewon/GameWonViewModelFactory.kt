package com.example.trivia.screen.gamewon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameWonViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameWonViewModelFactory::class.java)) {
            // TODO Construct and return the ScoreViewModel
            return GameWonViewModelFactory(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}