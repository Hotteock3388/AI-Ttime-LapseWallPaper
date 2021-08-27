package com.example.ai_timelapse_wallpaper.view.apply

import androidx.core.view.get
import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.model.repository.ImageRepository
import com.example.ai_timelapse_wallpaper.util.MyRecyclerViewAdapter
import com.example.ai_timelapse_wallpaper.view.main.MAdapter
import kotlinx.android.synthetic.main.layout_viewpager_item.view.*

class ApplyViewModel(private val repository: ImageRepository): BaseViewModel() {

    var adapter = MAdapter(Singleton.imageArr.value!!)

    val apply = MutableLiveData<Unit>()

    val cancel = MutableLiveData<Unit>()

    fun apply(){ apply.value = Unit }

    fun cancel(){ cancel.value = Unit }

}