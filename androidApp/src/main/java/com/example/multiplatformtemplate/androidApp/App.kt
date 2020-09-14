package com.example.multiplatformtemplate.androidApp

import android.app.Application
import com.example.multiplatformtemplate.data.local.appContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}