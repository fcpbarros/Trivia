package com.example.trivia.screen.game

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Collections.shuffle

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
    private var _currentQuestion = MutableLiveData<String>()
    val currentQuestion: LiveData<String>
        get() = _currentQuestion

    private var _answers = MutableLiveData<List<String>>()
    val answers: LiveData<List<String>>
        get() = _answers

    private var _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    private lateinit var questionsList: MutableList<Question>
    private lateinit var rightAnswer: String
    private lateinit var resps: List<String>

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
            /**
             * Update the UI with the question
             */
            _currentQuestion.value = questionsList[0].text
            resps = questionsList[0].answers
            rightAnswer = questionsList[0].answers[0]
            shuffle(resps)
            _answers.value = resps
            questionsList.removeAt(0)


        }

    }

    /**
     * Method to check answers
     */
    fun onAnsweredQuestion(answerString: String, toast: Toast) {
        //toast.show()
        if (answerString == rightAnswer) {
            toast.show()
        }

        //questionsList.removeAt(0)
        nextQuestion()

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