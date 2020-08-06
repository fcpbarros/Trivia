package com.example.trivia.screen.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trivia.R
import com.example.trivia.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    //binding object
    private lateinit var binding: GameFragmentBinding

    /**
     * Defining the questions
     * Creating the Question class -> In the future I will move this to a separate file
     */
    data class Question(
        val text: String,
        val answers: List<String>
    )

    /**
     * This is just a simple game at the moment so the everything will be hardcoded
     * In a later update the questions will be stored on a SQL Database
     */
    private val questions: MutableList<Question> = mutableListOf(
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
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    // private val numQuestions = Math.min((questions.size + 1) / 2, 3)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        /**
         * inflate the fragment
         */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container
            , false
        )



        return binding.root
    }
}