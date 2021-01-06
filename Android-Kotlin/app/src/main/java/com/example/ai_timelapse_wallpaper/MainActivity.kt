package com.example.ai_timelapse_wallpaper

import android.app.Activity
import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.ai_timelapse_wallpaper.service.MyServiceTest
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private lateinit var wallpaperManager : WallpaperManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallpaperManager = WallpaperManager.getInstance(applicationContext)

        btn_ClearWallPaper.setOnClickListener {
            wallpaperManager.clearWallpaper()

        }

        btn_SelectWallPaper.setOnClickListener {
            openGallery()
        }

        btn_StartBackground.setOnClickListener {
            val serviceIntent : Intent = Intent(applicationContext, MyService::class.java)
            startService(serviceIntent)
        }


        button_StartService.setOnClickListener {
            startService(Intent(applicationContext, MyServiceTest::class.java))
        }

        button_StopService.setOnClickListener {
            stopService(Intent(applicationContext, MyServiceTest::class.java))
        }

        button_StartMP3.setOnClickListener {
            var mediaPlayer = MediaPlayer()
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.sad)
            mediaPlayer.start()
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        startService(Intent(applicationContext, MyServiceTest::class.java))
    }

    private fun openGallery() {
        // 암시적 인텐트로 갤러리 열기
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 100){
            val imageUri : Uri? = data?.data

            //Uri 제대로 왔는지 테스트하는 코드
            //imageView.setImageURI(imageUri)
            
            val image : Bitmap = MediaStore.Images.Media.getBitmap(applicationContext.contentResolver, imageUri)

            try {
                wallpaperManager.setBitmap(image)
            } catch (ex: IOException) {
                ex.printStackTrace()
            }

        }
    }
}