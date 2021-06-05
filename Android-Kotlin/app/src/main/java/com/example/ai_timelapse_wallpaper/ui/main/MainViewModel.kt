package com.example.ai_timelapse_wallpaper.ui.main

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.data.local.Singleton

class MainViewModel: ViewModel() {

    lateinit var adapter: MAdapter

    fun getDummyList(context: Context): ArrayList<Drawable> {
        val arr = ArrayList<Drawable>()

        for(i in 0..3){
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.day, null)!!)
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.afternoon, null)!!)
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.night, null)!!)
        }

        return arr
    }

    fun getBitmapImageList(): ArrayList<Bitmap> {
        return Singleton.imageBitmapArr
    }

}