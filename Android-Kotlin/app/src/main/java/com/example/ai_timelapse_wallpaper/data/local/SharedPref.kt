package com.example.ai_timelapse_wallpaper.data.local

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import com.example.ai_timelapse_wallpaper.util.MyUtil


class SharedPref(val context: Context) {

    fun saveImageArr(arr: ArrayList<Uri>){
        return getPref(context).edit().let {
            for(i in 0 until 6){
                it.putString("ImageBitmap$i", MyUtil.bitmapToString(MyUtil.uriToBitmap(context, arr[i])!!))
            }

            it.apply()
        }
    }

    fun getImageArr(context: Context): ArrayList<Bitmap>{
        var arr = ArrayList<Bitmap>()
        for(i in 0 until 6){
            arr.add(MyUtil.stringToBitmap(getPref(context).getString("ImageBitmap$i", ""))!!)
        }
        return arr
    }

    fun getImage(context: Context, idx: Int): Bitmap? {
        return MyUtil.stringToBitmap(getPref(context).getString("ImageBitmap$idx", ""))
    }

    fun isExist(key: String): Boolean = getPref(context).contains(key)

    fun isExistImageArr(): Boolean = getPref(context).contains("ImageBitmap1")

    private fun getPref(context: Context): SharedPreferences =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE)

}
