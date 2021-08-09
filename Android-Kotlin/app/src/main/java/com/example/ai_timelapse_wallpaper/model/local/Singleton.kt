package com.example.ai_timelapse_wallpaper.model.local

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData


object Singleton {

    var imageArr = MutableLiveData<ArrayList<Bitmap>>()

    var selectedImageArr = ArrayList<Bitmap>()
}