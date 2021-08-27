package com.example.ai_timelapse_wallpaper.view.splash

import com.example.ai_timelapse_wallpaper.view.main.MainActivity

import android.content.Intent
import android.os.Bundle
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.databinding.ActivitySettingBinding
import com.example.ai_timelapse_wallpaper.databinding.ActivitySplashBinding
import com.example.ai_timelapse_wallpaper.view.apply.ApplyActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {

    override val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel.initImageData()

        startApplication()
    }

    private fun startApplication(){
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

}