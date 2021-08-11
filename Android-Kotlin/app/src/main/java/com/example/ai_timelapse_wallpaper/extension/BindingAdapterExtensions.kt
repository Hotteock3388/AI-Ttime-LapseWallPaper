package com.example.ai_timelapse_wallpaper.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.view.main.MainViewModel
import com.example.ai_timelapse_wallpaper.view.setting.SettingViewModel
import kotlinx.android.synthetic.main.layout_button.view.*


@BindingAdapter("app:clickMyGallery")
fun myGallery(view: View, viewModel: SettingViewModel){
    view.textView_ButtonText_ButtonLayout.text = "My Gallery"
    view.setOnClickListener {
        viewModel.clickMyGallery.value = Unit
    }
}

@BindingAdapter("app:clickRecommend")
fun recommend(view: View, viewModel: SettingViewModel){
    view.textView_ButtonText_ButtonLayout.text = "Recommend"
    view.setOnClickListener {
        viewModel.clickRecommend.value = Unit
    }
}

@BindingAdapter("app:currentPosition")
fun setCurrentPosition(view: ViewPager2, position: Int){
    view.currentItem = position
}
