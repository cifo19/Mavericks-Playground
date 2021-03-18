package com.playground.mavericks.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.playground.mavericks.R
import com.playground.mavericks.databinding.ActivityMainBinding
import com.playground.mavericks.main.counter.CounterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also { binding ->
            setContentView(binding.root)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragmentContainerView, CounterFragment(), "CounterFragment")
            }
        }
    }
}
