package com.example.trivia.screen.gamewon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trivia.R
import com.example.trivia.databinding.GameWonFragmentBinding


private lateinit var viewModel: GameWonViewModel
private lateinit var viewModelFactory: GameWonViewModelFactory

class GameWonFragment : Fragment() {

    //private val args: GameWonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding: GameWonFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_won_fragment,
            container, false
        )
        //binding.scoreTextView.text = args.score.toString()
        /**
         * Code to create the viewModel with the aid of the viewModelFactory
         */
        //viewModelFactory = GameWonViewModelFactory(args.score)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameWonViewModel::class.java)
        binding.gameWonViewModel = viewModel
        binding.lifecycleOwner = this
        /**
         * Observer to watch the variable _eventPlayAgain located inside the viewmodel ( GameWonViewModel )
         */
//        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
//            if (playAgain) {
//                findNavController().navigate(GameWonFragmentDirections.restart())
//                viewModel.onPlayAgainFinish()
//            }
//        })
        //let the system know that there is an OptionsMenu
        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Code to create and use the optionsMenu
     */
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.share_menu, menu)
//        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
//            // hide the menu item if it doesn't resolve
//            menu.findItem(R.id.share)?.isVisible = false
//        }
//    }

    /**
     * Code to handle the selected item
     */
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.share -> shareWin()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    /**
     * Code to create the intent
     */
//    private fun getShareIntent(): Intent {
//        val args = GameLostFragmentArgs.fromBundle(requireArguments())
//        return ShareCompat.IntentBuilder.from(requireActivity())
//            .setText(getString(R.string.share_win_text, args.score))
//            .setType("text/plain")
//            .intent
//    }

//    /**
//     * Sharing happens here
//     */
//    private fun shareWin() {
//        startActivity(getShareIntent())
//    }

}




