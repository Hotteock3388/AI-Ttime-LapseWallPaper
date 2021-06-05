package com.example.ai_timelapse_wallpaper.ui.loading

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.ui.apply.ApplyActivity

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Thread.sleep(3000)


        startActivity(Intent(this, ApplyActivity::class.java))

    }

}
