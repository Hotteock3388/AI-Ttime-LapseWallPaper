package com.example.ai_timelapse_wallpaper.di.app

import android.app.Application
import com.example.ai_timelapse_wallpaper.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication: Application() {

    companion object {
        const val BASE_URL = ""
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                activityModule,
                apiModule,
                networkModule,
                repositoryModule
            )
        }
    }

}