package com.example.trivia.screen.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.TitleFragmentBinding


class TitleFragment : Fragment() {

    /**
     * Instanciate the binding object
     */
    private lateinit var binding: TitleFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * inflate the fragment
         */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment
            , container, false
        )

        /**
         * Listener for the play_button to navigate to the gameFragment
         */
        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }


        return binding.root
    }
}