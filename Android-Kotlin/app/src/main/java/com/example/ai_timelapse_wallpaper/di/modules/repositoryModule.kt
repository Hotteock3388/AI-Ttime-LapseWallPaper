package com.example.ai_timelapse_wallpaper.di.modules

import com.example.ai_timelapse_wallpaper.model.local.SharedPref
import com.example.ai_timelapse_wallpaper.model.repository.ImageRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single {
        SharedPref(androidContext())
    }

    factory {
        ImageRepository(get())
    }
}