package com.example.ai_timelapse_wallpaper.view.apply

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.model.local.SharedPref
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.databinding.ActivityApplyBinding
import com.example.ai_timelapse_wallpaper.util.MyRecyclerViewAdapter
import com.example.ai_timelapse_wallpaper.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply) {

    override val viewModel: ApplyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.adapter = MyRecyclerViewAdapter(Singleton.imageArr.value!!)


        with(binding){
            activity = this@ApplyActivity
            recyclerViewApplyActivity.adapter = viewModel.adapter
            viewModel.adapter.notifyDataSetChanged()
        }

    }

    fun apply(){
        SharedPref(this).saveBitmapImageArr(Singleton.imageArr.value!!)

        fin("적용 완료")
    }

    fun cancel(){
        fin("취소")
    }

    fun fin(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}