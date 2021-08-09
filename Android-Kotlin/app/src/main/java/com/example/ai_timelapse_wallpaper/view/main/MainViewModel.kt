package com.example.ai_timelapse_wallpaper.view.main

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton

class MainViewModel: BaseViewModel() {

    var adapter = MAdapter(Singleton.imageArr.value!!)

    var imageSettingButtonCLick = MutableLiveData<Unit>()

    fun getBitmapImageList(): ArrayList<Bitmap> {
        return Singleton.imageArr.value!!
    }

    fun imageSetting(){
        imageSettingButtonCLick.value = Unit
    }

}