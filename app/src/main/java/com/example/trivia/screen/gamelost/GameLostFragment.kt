package com.example.trivia.screen.gamelost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        return binding.root
    }
}