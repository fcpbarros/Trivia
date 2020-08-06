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
import androidx.lifecycle.ViewModelProviders
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
            val toast = Toast.makeText(activity, "noiiiis", Toast.LENGTH_SHORT)
            viewModel.onAnsweredQuestion(radio.text.toString(), toast)

        }

        return binding.root
    }

}