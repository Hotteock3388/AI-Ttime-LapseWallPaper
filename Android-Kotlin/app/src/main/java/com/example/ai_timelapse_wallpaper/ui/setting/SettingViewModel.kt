package com.example.ai_timelapse_wallpaper.ui.setting

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.databinding.ActivitySettingBinding
import kotlinx.android.synthetic.main.layout_button.view.*

class SettingViewModel: ViewModel() {

    lateinit var adapter : SettingRecyclerViewAdapter

    fun getDummyList(context: Context): ArrayList<Drawable> {
        val arr = ArrayList<Drawable>()

        for(i in 0..3){
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.day, null)!!)
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.afternoon, null)!!)
            arr.add(ResourcesCompat.getDrawable(context.resources, R.drawable.night, null)!!)
        }

        return arr
    }

}