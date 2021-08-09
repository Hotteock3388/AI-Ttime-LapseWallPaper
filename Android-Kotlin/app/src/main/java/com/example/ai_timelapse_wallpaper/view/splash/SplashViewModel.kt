package com.example.ai_timelapse_wallpaper.view.splash

import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.model.repository.ImageRepository

class SplashViewModel(private val imageRepo: ImageRepository): BaseViewModel() {

    fun initImageData(){
        Singleton.imageArr.value = imageRepo.getImageData()
    }

}