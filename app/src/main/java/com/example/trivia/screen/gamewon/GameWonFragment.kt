package com.example.trivia.screen.gamewon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.trivia.R
import com.example.trivia.databinding.GameWonFragmentBinding


private lateinit var viewModel: GameWonViewModel
private lateinit var viewModelFactory: GameWonViewModelFactory

class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding: GameWonFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_won_fragment,
            container, false
        )

        //get Args
        val gameWonFragmentArgs by navArgs<GameWonFragmentArgs>()

        //create viewModel
        viewModelFactory = GameWonViewModelFactory(gameWonFragmentArgs.score)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameWonViewModel::class.java)

        //binding.gameWonViewModel = viewModel


        return binding.root
    }
}




