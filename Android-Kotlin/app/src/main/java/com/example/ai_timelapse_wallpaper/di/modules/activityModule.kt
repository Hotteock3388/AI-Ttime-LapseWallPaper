package com.example.ai_timelapse_wallpaper.di.modules

import com.example.ai_timelapse_wallpaper.view.apply.ApplyViewModel
import com.example.ai_timelapse_wallpaper.view.loading.LoadingViewModel
import com.example.ai_timelapse_wallpaper.view.main.MainViewModel
import com.example.ai_timelapse_wallpaper.view.setting.SettingViewModel
import com.example.ai_timelapse_wallpaper.view.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val activityModule = module {

    viewModel {
        SplashViewModel(get())
    }

    viewModel {
        MainViewModel()
    }

    viewModel {
        SettingViewModel()
    }

    viewModel {
        LoadingViewModel()
    }

    viewModel {
        ApplyViewModel(get())
    }

}