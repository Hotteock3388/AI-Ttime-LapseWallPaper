package com.example.ai_timelapse_wallpaper.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.databinding.ActivityMainBinding
import com.example.ai_timelapse_wallpaper.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    lateinit var binding: ActivityMainBinding


//    private lateinit var binding: AcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //ViewModel 초기화
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //ViewPager Adapter 초기화
        viewModel.adapter = MAdapter(viewModel.getUriImageList())

        with(binding){
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
            vm = viewModel
            binding.viewPagerMainActivity.adapter = viewModel.adapter
        }

        viewModel.adapter.notifyDataSetChanged()

    }

    fun imageSetting(){
        viewModel.adapter.notifyDataSetChanged()
        startActivity(Intent(this, SettingActivity::class.java))
    }

    fun viewPagerPrevPage(){
        if(binding.viewPagerMainActivity.currentItem != 0){
            binding.viewPagerMainActivity.currentItem--
        }
    }

    fun viewPagerNextPage(){
        if(binding.viewPagerMainActivity.currentItem != viewModel.getUriImageList().size - 1){
            binding.viewPagerMainActivity.currentItem++
        }
    }

}