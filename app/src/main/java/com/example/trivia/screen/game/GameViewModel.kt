package com.example.trivia.screen.game

import android.util.Log
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

    //var score = 0 -> needs to be initialized
    private var _score = MutableLiveData<Int>() //_score is initialized to null --INTERNAL VERSION
    val score: LiveData<Int>
        get() = _score

    //make a LiveData for the finish event
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    //make a LiveData for the win event
    private val _eventGameResult = MutableLiveData<Boolean>()
    val eventGameResult: LiveData<Boolean>
        get() = _eventGameResult


    private lateinit var questionsList: MutableList<Question>
    private lateinit var rightAnswer: String
    private lateinit var resps: List<String>

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        defineQuestion()
        nextQuestion()
        _score.value = 0
        _eventGameFinish.value = false
        _eventGameResult.value = false
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
        } else {
            //Here the user loses the game because there are no more questions
            /**
             * In case user loses the game _eventGameResult = false
             */
            _eventGameFinish.value = true
        }
    }

    /**
     * Method to check answers
     */
    fun onAnsweredQuestion(answerString: String) {
        //toast.show()
        if (answerString == rightAnswer) {
            _score.value = (score.value)?.plus(1)
            /**
             * check the score
             */
            if (_score.value!! >= 5) {
                //Game won!
                _eventGameResult.value = true
                _eventGameFinish.value = true
            } else {
                nextQuestion()
            }

        } else {
            //Wrong answer!
            nextQuestion()
        }

    }

    /**
     * onGameFinishedComplete - This method resets the game
     */
    fun onGameFinishComplete() {
        // These lines reset the game
        _eventGameResult.value = false
        //_eventGameLost.value = false
        _eventGameFinish.value = false
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