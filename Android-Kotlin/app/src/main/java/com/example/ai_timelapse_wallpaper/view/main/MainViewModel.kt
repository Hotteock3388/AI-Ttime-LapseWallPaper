package com.example.ai_timelapse_wallpaper.view.main

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton

class MainViewModel: BaseViewModel() {

    var adapter = MAdapter(Singleton.imageArr.value!!)

    var imageSettingButtonClick = MutableLiveData<Unit>()

    var vpPosition = MutableLiveData<Int>()


    init {
        vpPosition.value = 0
    }

    fun getBitmapImageList(): ArrayList<Bitmap> {
        return Singleton.imageArr.value!!
    }

    fun imageSetting(){
        imageSettingButtonClick.value = Unit
    }

    fun vpPrevPage(){
        if(vpPosition.value != 0){
            vpPosition.postValue(vpPosition.value!! - 1)
        }
    }

    fun vpNextPage(){
        if(vpPosition.value != Singleton.imageArr.value?.size){
            vpPosition.postValue(vpPosition.value!! + 1)
        }
    }

}