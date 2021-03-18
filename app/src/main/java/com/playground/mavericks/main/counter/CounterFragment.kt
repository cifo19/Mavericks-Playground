package com.playground.mavericks.main.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.playground.mavericks.databinding.FragmentCounterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CounterFragment : Fragment(), MavericksView {

    private val counterViewModel by fragmentViewModel(CounterViewModel::class)

    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clickButton.setOnClickListener {
            counterViewModel.click()
        }
    }

    override fun invalidate() = withState(counterViewModel) {
        binding.nameTextView.text = it.count.toString()
    }
}
