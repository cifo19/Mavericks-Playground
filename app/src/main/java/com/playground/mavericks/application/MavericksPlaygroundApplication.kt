package com.playground.mavericks.application

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MavericksPlaygroundApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
