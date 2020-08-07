package com.example.trivia.screen.gamelost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class GameLostViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameLostViewModel::class.java)) {
            return GameLostViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}