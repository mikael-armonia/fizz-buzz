package com.mikaelarmonia.fizzbuzz

import android.app.Application
import com.mikaelarmonia.fizzbuzz.di.fizzBuzzModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FizzBuzzApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FizzBuzzApplication)
            modules(fizzBuzzModules)
        }
    }
}