package com.example.trivia.screen.gamelost

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
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

        binding.scoreTextView.text = args.score.toString()
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

        //let the system know that there is an OptionsMenu
        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Code to create and use the optionsMenu
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    /**
     * Code to handle the selected item
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareLoss()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Code to create the intent
     */
    private fun getShareIntent(): Intent {
        val args = GameLostFragmentArgs.fromBundle(requireArguments())
        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_loss_text, args.score))
            .setType("text/plain")
            .intent
    }

    /**
     * Sharing happens here
     */
    private fun shareLoss() {
        startActivity(getShareIntent())
    }

}