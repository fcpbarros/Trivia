package com.example.trivia.screen.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    /**
     * Creating the question class
     */
    data class Question(
        val text: String,
        val answers: List<String>
    )

    /**
     * From now on all the logic of the gameFragment will be done here
     * Here we use LiveData with encapsulation
     */
    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    private var _answers = MutableLiveData<MutableList<String>>()
    val answers: LiveData<MutableList<String>>
        get() = _answers

    private var _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    private lateinit var questionsList: MutableList<Question>

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        defineQuestion()
        nextQuestion()
    }


    /**
     * Next question
     */
    private fun nextQuestion() {
        if (questionsList.isNotEmpty()) {
            //Game is on
            _currentQuestion.value = questionsList.removeAt(0)

        } else {
            //game is over
        }
    }

    /**
     * Defining the questions
     */
    private fun defineQuestion() {

        questionsList = mutableListOf(
            Question(
                text = "What is Android Jetpack?",
                answers = listOf("all of these", "tools", "documentation", "libraries")
            ),
            Question(
                text = "Base class for Layout?",
                answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
            ),
            Question(
                text = "Layout for complex Screens?",
                answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
            ),
            Question(
                text = "Pushing structured data into a Layout?",
                answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
            ),
            Question(
                text = "Inflate layout in fragments?",
                answers = listOf(
                    "onCreateView",
                    "onActivityCreated",
                    "onCreateLayout",
                    "onInflateLayout"
                )
            ),
            Question(
                text = "Build system for Android?",
                answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
            ),
            Question(
                text = "Android vector format?",
                answers = listOf(
                    "VectorDrawable",
                    "AndroidVectorDrawable",
                    "DrawableVector",
                    "AndroidVector"
                )
            ),
            Question(
                text = "Android Navigation Component?",
                answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
            ),
            Question(
                text = "Registers app with launcher?",
                answers = listOf(
                    "intent-filter",
                    "app-registry",
                    "launcher-registry",
                    "app-launcher"
                )
            ),
            Question(
                text = "Mark a layout for Data Binding?",
                answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
            )
        )
        questionsList.shuffle()

    }

}