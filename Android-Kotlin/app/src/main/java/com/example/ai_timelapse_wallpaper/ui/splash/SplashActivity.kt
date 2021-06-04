package com.example.ai_timelapse_wallpaper.ui.splash

import com.example.ai_timelapse_wallpaper.ui.main.MainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.ai_timelapse_wallpaper.R

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        viewModel.getImageDataFromSharedPref(baseContext)

        startApplication()
    }

    private fun startApplication(){
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

}