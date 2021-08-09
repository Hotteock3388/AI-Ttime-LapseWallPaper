package com.example.ai_timelapse_wallpaper.view.apply

import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.model.repository.ImageRepository
import com.example.ai_timelapse_wallpaper.util.MyRecyclerViewAdapter

class ApplyViewModel(private val repository: ImageRepository): BaseViewModel() {

    var adapter = MyRecyclerViewAdapter(Singleton.selectedImageArr)

    val fin = MutableLiveData<String>()

    fun apply(){
        repository.saveImageDataToSharedPref(Singleton.selectedImageArr)
        finish("적용 완료")
    }

    fun cancel(){
        finish("취소")
    }

    private fun finish(msg: String){
        fin.value = msg
    }

}