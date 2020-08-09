package com.example.trivia.screen.result

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trivia.R
import com.example.trivia.databinding.ResultFragmentBinding


class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel
    private lateinit var viewModelFactory: ResultViewModelFactory
    private lateinit var binding: ResultFragmentBinding
    private var message: String = ""

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * Creating the biding object
         */
        val binding: ResultFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.result_fragment,
            container, false
        )

        /**
         * Code to create the viewModel with the aid of the viewModelFactory
         */
        viewModelFactory = ResultViewModelFactory(args.finalScore, args.result)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ResultViewModel::class.java)
        binding.resultViewModel = viewModel
        binding.lifecycleOwner = this
        /**
         * Observer to watch the _eventPlayAgain inside the ResultViewModel
         */
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgain ->
            if (playAgain) {
                findNavController().navigate(ResultFragmentDirections.restart())
                viewModel.onPlayAgainFinish()
            }
        })
        /**
         * Observer to watch the _result inside the ResultViewModel
         * if true, user has won
         */
        viewModel.result.observe(viewLifecycleOwner, Observer { gameResult ->
            if (gameResult) {
                //(getString(R.string.share_text, args.finalScore))
                message = getString(R.string.share_text_win, "won", viewModel.score.value)
                binding.scoreTextView.text = message
            } else {
                message = getString(R.string.share_text_lost, "lost", viewModel.score.value)
                binding.scoreTextView.text = message
            }
            setHasOptionsMenu(gameResult)
        })

        //let the system know that there is an OptionsMenu
        //setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
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
            R.id.share -> share()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Code to create the intent
     */
    private fun getShareIntent(): Intent {
        //val args = ResultFragmentArgs.fromBundle(requireArguments())
        //var texto:CharSequence = binding.scoreTextView.text
        //val message = texto.toString()
        return ShareCompat.IntentBuilder.from(requireActivity())
            //.setText(getString(R.string.share_text, args.finalScore))
            .setText(message)
            .setType("text/plain")
            .intent
    }

    /**
     * Sharing happens here
     */
    private fun share() {
        startActivity(getShareIntent())
    }
}