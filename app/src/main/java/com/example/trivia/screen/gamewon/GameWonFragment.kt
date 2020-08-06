package com.example.trivia.screen.gamewon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trivia.R
import com.example.trivia.databinding.GameWonFragmentBinding


private lateinit var viewModel: GameWonViewModel
private lateinit var viewModelFactory: GameWonViewModelFactory

class GameWonFragment : Fragment() {

    private val args: GameWonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding: GameWonFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_won_fragment,
            container, false
        )

        binding.scoreTextView.text = args.score.toString()
        /**
         * Code to create the viewModel with the aid of the viewModelFactory
         */
        viewModelFactory = GameWonViewModelFactory(args.score)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameWonViewModel::class.java)
        binding.gameWonViewModel = viewModel
        binding.lifecycleOwner = this

        /**
         * Observer to watch the variable _eventPlayAgain located inside the viewmodel ( GameWonViewModel )
         */
        viewModel.eventPlayAgain.observe(this, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(GameWonFragmentDirections.restart())
                viewModel.onPlayAgainFinish()
            }
        })

        return binding.root
    }


}




