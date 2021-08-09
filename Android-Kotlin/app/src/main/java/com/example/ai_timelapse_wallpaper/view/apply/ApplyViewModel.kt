package com.example.ai_timelapse_wallpaper.view.apply

import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.SharedPref
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.util.MyRecyclerViewAdapter

class ApplyViewModel(private val sharedPref: SharedPref): BaseViewModel() {

    var adapter = MyRecyclerViewAdapter(Singleton.selectedImageArr)

    val fin = MutableLiveData<String>()

    fun apply(){
        with(Singleton){
            imageArr.value = selectedImageArr
            sharedPref.saveBitmapImageArr(selectedImageArr)
        }
        fin.value = "적용 완료"
    }

    fun cancel(){
        fin.value = "취소"
    }

}