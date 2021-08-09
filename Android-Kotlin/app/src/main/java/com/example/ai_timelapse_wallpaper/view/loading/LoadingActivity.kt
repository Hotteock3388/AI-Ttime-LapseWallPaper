package com.example.ai_timelapse_wallpaper.view.loading

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.view.apply.ApplyActivity

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Handler().postDelayed({
            //서버 통신 메서드 넣기 전까지 대신 2초 딜레이
            finish()
            startActivity(Intent(this, ApplyActivity::class.java))

        }, 2000)
    }

}
