package com.example.ai_timelapse_wallpaper.model.local

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import com.example.ai_timelapse_wallpaper.util.MyUtil


class SharedPref(val context: Context) {

    fun saveBitmapImageArr(arr: ArrayList<Bitmap>){
        var idx = 0
        getPref(context).edit().let {
            for(i in 0 until arr.size){
                it.putString(getKey(i), MyUtil.bitmapToString(arr[i]))
                idx = i
            }
            removePrevImage(++idx)

            it.apply()
        }
    }

    //테스트 전용 메서드
    private fun removePrevImage(i: Int){
        if(isExist(getKey(i))){
            getPref(context).edit().let {
                it.remove(getKey(i))
                it.apply()
            }
            removePrevImage(i + 1)
        }
    }

    //계속 "ImageBitmap$i" 중복되는게 너무 꼴뵈기 싫어서 만든 메서드
    private fun getKey(idx: Int): String {
        return "ImageBitmap$idx"
    }


    fun getImageArr(): ArrayList<Bitmap>{
        var arr = ArrayList<Bitmap>()
        var i = 0
        while (isExist(getKey(i))){
            arr.add(MyUtil.stringToBitmap(getPref(context).getString(getKey(i), ""))!!)
            i++
        }
        return arr
    }

    fun getImage(idx: Int): Bitmap? {
        return MyUtil.stringToBitmap(getPref(context).getString(getKey(idx), ""))
    }

    fun isExist(key: String): Boolean = getPref(context).contains(key)

    fun isExistImageArr(): Boolean = getPref(context).contains(getKey(0))

    private fun getPref(context: Context): SharedPreferences =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE)

}
