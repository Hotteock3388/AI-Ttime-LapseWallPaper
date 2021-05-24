package com.example.ai_timelapse_wallpaper.ui.splash

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ai_timelapse_wallpaper.data.local.SharedPref
import com.example.ai_timelapse_wallpaper.data.local.Singleton

class SplashViewModel: ViewModel() {

    fun getImageDataFromSharedPref(context: Context){
        val sharedPref = SharedPref(context)

        if(sharedPref.isExistImageArr()){
            Singleton.imageBitmapArr = sharedPref.getImageArr(context)
            Log.d("TestLog_SplashVM", "ImageArr 있음 size ${Singleton.imageBitmapArr.size}")
        } else{
            Log.d("TestLog_SplashVM", "ImageArr 없음")
        }
    }

}