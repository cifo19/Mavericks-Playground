package com.playground.mavericks.main.counter

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlin.random.Random

data class CounterState(val count: Int = 0) : MavericksState

class CounterViewModel(
    initialState: CounterState
) : MavericksViewModel<CounterState>(initialState) {

    fun click() {
        val randomCount = Random.nextInt(0, 100)
        setState {
            copy(count = randomCount)
        }
    }
}
