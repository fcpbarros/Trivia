package com.example.trivia.screen.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.trivia.R
import com.example.trivia.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    //binding object
    private lateinit var binding: GameFragmentBinding

    /**
     * Defining the questions - Moved to the ViewModel
     * Creating the Question class -> In the future I will move this to a separate file
     * moved to the viewModel
     */
//    data class Question(
//        val text: String,
//        val answers: List<String>
//    )

    /**
     * This is just a simple game at the moment so the everything will be hardcoded
     * In a later update the questions will be stored on a SQL Database
     * the first position (index = 0) is always the right answer
     * Moved to viewModel
     */
//    private val questions: MutableList<Question> = mutableListOf(
//        Question(
//            text = "What is Android Jetpack?",
//            answers = listOf("all of these", "tools", "documentation", "libraries")
//        ),
//        Question(
//            text = "Base class for Layout?",
//            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
//        ),
//        Question(
//            text = "Layout for complex Screens?",
//            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
//        ),
//        Question(
//            text = "Pushing structured data into a Layout?",
//            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
//        ),
//        Question(
//            text = "Inflate layout in fragments?",
//            answers = listOf(
//                "onCreateView",
//                "onActivityCreated",
//                "onCreateLayout",
//                "onInflateLayout"
//            )
//        ),
//        Question(
//            text = "Build system for Android?",
//            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
//        ),
//        Question(
//            text = "Android vector format?",
//            answers = listOf(
//                "VectorDrawable",
//                "AndroidVectorDrawable",
//                "DrawableVector",
//                "AndroidVector"
//            )
//        ),
//        Question(
//            text = "Android Navigation Component?",
//            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
//        ),
//        Question(
//            text = "Registers app with launcher?",
//            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
//        ),
//        Question(
//            text = "Mark a layout for Data Binding?",
//            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
//        )
//    )

    //   lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    // private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    //This line makes the fragment know the view model
    private lateinit var viewModel: GameViewModel

    /**
     * The following line creates an instance of GameViewModel and assigns it to
     * the lateinit variable created viewModel
     */


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

        /**
         * Methods for setting the viewModel
         */
        Log.i("GameFragment", "Called ViewModelProviders.of! ")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)


        binding.gameViewModel = viewModel
        binding.lifecycleOwner = this

        /**
         * randomize the questions and display the first question
         */
        //randomizeQuestions() -> moved to viewModel

        /**
         * bind the fragment class to the layout
         */
        //binding.game = this

        /**
         * The questions are being shown
         * Now the next step is to implement the listener to the radioButtons in order to
         * control the logic of the game -> Moved to the viewModel
         */
//        binding.questionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->
//            // In case a button is checked
//            if (checkedId != -1) {
//                //defining the right answer
//                var answerIndex = 0 // this line assumes the first radioButton was clicked
//                /**
//                 * The when block detects which button was clicked and gives it the proper Index
//                 */
//                when (checkedId) {
//                    // R.id.answer_one -> answerIndex = 0
//                    R.id.answer_two -> answerIndex = 1
//                    R.id.answer_three -> answerIndex = 2
//                    R.id.answer_four -> answerIndex = 3
//                }
//                //check if selected answer is the right answer (position 0 at "answers")
//                if (answers[answerIndex] == currentQuestion.answers[0]) {
//                    //It is the right answer
//                    Toast.makeText(activity, "Right!", Toast.LENGTH_SHORT).show()
//                    //remove the current question from the list of possible question
//                } else {
//                    //It is the wrong answer
//                    Toast.makeText(activity, "Wrong!", Toast.LENGTH_SHORT).show()
//                }
//
//
//            } //end of if(checkedItem != -1)
//        }   //end of binding.questionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->


        return binding.root
    }

    /**
     * Method to randomize the questions
     * moved to viewModel
     */
//    private fun randomizeQuestions() {
//        questions.shuffle()
//        questionIndex = 0
//        showQuestion()
//    }

//    private fun showQuestion() {
//        //get the first question located at question index
//        currentQuestion = questions[questionIndex]
//        answers =
//            currentQuestion.answers.toMutableList() //copies the answers to a MutableList in order to randomize it
//        //randomizing the answers
//        answers.shuffle()
//    }


}