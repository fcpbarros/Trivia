package com.example.trivia.screen.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trivia.R
import com.example.trivia.databinding.RulesFragmentBinding

class RulesFragment : Fragment() {

    private lateinit var binding: RulesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Inflate the RulesFragment
         */
        binding = DataBindingUtil.inflate(
            inflater, R.layout.rules_fragment, container
            , false
        )

        return binding.root
    }
}