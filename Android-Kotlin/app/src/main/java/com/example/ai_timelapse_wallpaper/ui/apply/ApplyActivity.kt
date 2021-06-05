package com.example.ai_timelapse_wallpaper.ui.apply

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.data.local.SharedPref
import com.example.ai_timelapse_wallpaper.data.local.Singleton
import com.example.ai_timelapse_wallpaper.databinding.ActivityApplyBinding
import com.example.ai_timelapse_wallpaper.util.MyDummyRecyclerViewAdapter
import com.example.ai_timelapse_wallpaper.util.MyRecyclerViewAdapter
import io.reactivex.Single

class ApplyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApplyBinding

    private lateinit var viewModel: ApplyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ApplyViewModel::class.java)

        viewModel.adapter = MyRecyclerViewAdapter(Singleton.imageBitmapArr)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_apply)

        with(binding){
            activity = this@ApplyActivity
            vm = viewModel
            lifecycleOwner = this@ApplyActivity
            recyclerViewApplyActivity.adapter = viewModel.adapter
            viewModel.adapter.notifyDataSetChanged()
        }

    }

    fun apply(){
        Toast.makeText(this, "적용 완료!", Toast.LENGTH_SHORT).show()
        SharedPref(this).saveImageArr(Singleton.imageUriArr)
    }

    fun cancel(){
        Toast.makeText(this, "취소!", Toast.LENGTH_SHORT).show()
    }

}