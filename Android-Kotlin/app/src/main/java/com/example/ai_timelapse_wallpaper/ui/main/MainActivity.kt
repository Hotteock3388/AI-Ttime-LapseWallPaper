package com.example.ai_timelapse_wallpaper.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.databinding.ActivityMainBinding
import com.example.ai_timelapse_wallpaper.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

//    private lateinit var binding: AcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        with(binding){
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
            vm = viewModel
        }
        val adapter = MAdapter(viewModel.getDummyList(baseContext))
        viewPager_MainActivity.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    fun imageSetting(){
        startActivity(Intent(this, SettingActivity::class.java))
    }
}