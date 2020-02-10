package com.onemain.challenge

import android.app.Application
import com.onemain.challenge.koin.modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DadJokeApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DadJokeApplication)
            modules(modules)
        }
    }
}