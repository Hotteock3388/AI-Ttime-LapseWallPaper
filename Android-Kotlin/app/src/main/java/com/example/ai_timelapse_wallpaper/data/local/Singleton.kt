package com.example.ai_timelapse_wallpaper.data.local

import android.graphics.Bitmap
import android.media.MediaPlayer
import android.net.Uri


object Singleton {
    val imageUriArr = ArrayList<Uri>()

    var imageBitmapArr = ArrayList<Bitmap>()
}