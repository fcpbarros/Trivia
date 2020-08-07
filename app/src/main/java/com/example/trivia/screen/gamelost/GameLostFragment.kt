package com.example.trivia.screen.gamelost

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
import com.example.trivia.databinding.GameLostFragmentBinding


private lateinit var viewModel: GameLostViewModel
private lateinit var viewModelFactory: GameLostViewModelFactory

class GameLostFragment : Fragment() {

    private val args: GameLostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: GameLostFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_lost_fragment,
            container, false
        )

        binding.textView2.text = args.score.toString()
        /**
         * Code to create the viewModel with the aid of the viewModelFactory
         */
        viewModelFactory = GameLostViewModelFactory(args.score)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameLostViewModel::class.java)
        binding.gameLostViewModel = viewModel
        binding.lifecycleOwner = this
        /**
         * Observer to watch the variable _eventPlayAgain located inside the viewmodel ( GameWonViewModel )
         */
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(GameLostFragmentDirections.restartLost())
                viewModel.onPlayAgainFinish()
            }
        })

        return binding.root
    }
}