package com.example.ai_timelapse_wallpaper.activity

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.service.ChangeWallPaperService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        removeTitleAction()
        if(!this.isServiceRunning(ChangeWallPaperService::class.java)){
            startForegroundService(Intent(applicationContext, ChangeWallPaperService::class.java))
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
    }

    fun removeTitleAction(){
        // hide actionBar
        val actionBar = supportActionBar
        actionBar?.hide()

        //hide titleBar(fullScreen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }


    //서비스가 이미 실행중인지 확인
    fun Context.isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.d("isServiceRunning", "Service is running")
                return true
            }
        }
        return false
    }

}