package com.playground.mavericks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.airbnb.mvrx.*
import com.playground.mavericks.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlin.random.Random

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MavericksView {

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        lifecycleScope.launchWhenCreated {
            mainViewModel.stateFlow.collect {
                binding.nameTextView.text = it.name
            }
        }

        binding.clickButton.setOnClickListener {
            mainViewModel.click()
        }
    }

    override fun invalidate() = withState(mainViewModel) {
        // Hello
    }
}

class MainViewModel(initialState: MainState) : MavericksViewModel<MainState>(initialState) {

    fun click() {
        val random = Random.nextInt(0, 100)
        setState {
            copy(name = "New $random")
        }
    }
}

data class MainState(val name: String = "Initial State") : MavericksState
