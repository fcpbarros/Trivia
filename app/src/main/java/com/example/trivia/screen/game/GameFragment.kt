package com.example.trivia.screen.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.trivia.R
import com.example.trivia.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    //binding object
    private lateinit var binding: GameFragmentBinding

    /**
     * The following line creates an instance of GameViewModel and assigns it to
     * the lateinit variable created viewModel
     */
    //This line makes the fragment know the view model
    private lateinit var viewModel: GameViewModel


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
         * The questions are being shown
         * Now the next step is to implement the listener to the check button in order to
         * control the logic of the game -> Moved to the viewModel
         */
//        binding.questionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->
//            val toast = Toast.makeText(activity, "Right!", Toast.LENGTH_SHORT)
//            viewModel.onAnsweredQuestion(checkedId,toast)
//        }

        binding.answerButton.setOnClickListener { v: View? ->
            val checkedId = binding.questionsRadioGroup.checkedRadioButtonId
            val radio: RadioButton = binding.questionsRadioGroup.findViewById(checkedId)
            val toast = Toast.makeText(activity, "Game Won!", Toast.LENGTH_SHORT)
            viewModel.onAnsweredQuestion(radio.text.toString())

        }

        /**
         * Observer to watch changes on eventGameWin
         */
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { hasWon ->
            if (hasWon) {
                gameFinished(viewModel.eventGameResult)
                viewModel.onGameFinishComplete()
            }
        })
        /**
         * Observer to watch changes on eventGameLost
         */
//        viewModel.eventGameLost.observe(viewLifecycleOwner, Observer { hasLost ->
//            if (hasLost) {
//                gameFinished(viewModel.eventGameLost)
//                viewModel.onGameFinishComplete()
//            }
//        })


        return binding.root
    }

    /**
     * GameWon
     */
    private fun gameFinished(endResult: LiveData<Boolean>) {
        val currentScore = viewModel.score.value ?: 0
        val currentResult = viewModel.eventGameResult.value ?: false
        //val action = GameFragmentDirections.actionGameFragmentToGameWonFragment(currentScore)
        /**
         * In case user loses the game _eventGameResult = false
         */
        val action = GameFragmentDirections.actionGameFragmentToResultFragment(
            currentScore,
            currentResult
        ) //this may cause problem
        NavHostFragment.findNavController(this).navigate(action)
    }

    /**
     * GameLost
     */
//    private fun gameLost() {
//        val currentScore = viewModel.score.value ?: 0
//        val action = GameFragmentDirections.actionGameFragmentToGameLostFragment(currentScore)
//        NavHostFragment.findNavController(this).navigate(action)
//    }

}