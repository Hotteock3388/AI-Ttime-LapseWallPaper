package com.example.ai_timelapse_wallpaper.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.view.setting.SettingViewModel
import kotlinx.android.synthetic.main.layout_button.view.*


@BindingAdapter("clickMyGallery")
fun myGallery(view: View, viewModel: SettingViewModel){
    view.textView_ButtonText_ButtonLayout.text = "My Gallery"
    view.setOnClickListener {
        viewModel.clickMyGallery.value = Unit
    }
}

@BindingAdapter("clickRecommend")
fun recommend(view: View, viewModel: SettingViewModel){
    view.textView_ButtonText_ButtonLayout.text = "Recommend"
    view.setOnClickListener {
        viewModel.clickRecommend.value = Unit
    }
}

@BindingAdapter("ClickViewPagerButton")
fun clickViewPagerButton(view: ViewPager2, direct: String){
    if(direct == "Prev" && view.currentItem != 0){
        view.currentItem.minus(1)
    }
    else if (direct == "Next" && view.currentItem != Singleton.imageArr.value?.size?.minus(1)){
        view.currentItem.plus(1)
    }
}

