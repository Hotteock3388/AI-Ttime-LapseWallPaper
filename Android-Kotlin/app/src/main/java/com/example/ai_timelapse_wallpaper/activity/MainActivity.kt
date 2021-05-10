package com.example.ai_timelapse_wallpaper.activity

import android.app.Activity
import android.app.ActivityManager
import android.app.WallpaperManager
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.Singleton
import com.example.ai_timelapse_wallpaper.service.ChangeWallPaperService
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    val PICTURE_REQUEST_CODE = 2141

    private lateinit var wallpaperManager : WallpaperManager
    private lateinit var mainViewModel: MainViewModel
    private lateinit var imageViewArr: ArrayList<ImageView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        wallpaperManager = WallpaperManager.getInstance(applicationContext)

        setOnclick()

        removeTitleAction()
        if(!this.isServiceRunning(ChangeWallPaperService::class.java)){
            startForegroundService(Intent(applicationContext, ChangeWallPaperService::class.java))
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
    }

    private fun setOnclick() {
        btn_ClearWallPaper.setOnClickListener {
            wallpaperManager.clearWallpaper()

        }

        btn_SelectWallPaper.setOnClickListener {
            openGallery()
        }
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

    private fun openGallery() {
        // 암시적 인텐트로 갤러리 열기
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)

        //Intent.createChooser 어디에서 사진을 고를건지 선택하게 해줌(갤러리, 포토, 클라우드)
        startActivityForResult(Intent.createChooser(intent, "배경화면 선택"), PICTURE_REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == PICTURE_REQUEST_CODE){
            val imageUri : Uri? = data?.data

            val clipData = data?.clipData
            var i = 0

            for (i in 0 until 6){
                Singleton.imageArrs.add(clipData!!.getItemAt(i).uri)
            }

            //val image : Bitmap = MediaStore.Images.Media.getBitmap(applicationContext.contentResolver, imageUri)

                for(i in 0 until 6){
                    imageViewArr[i].setImageURI(Singleton.imageArrs[i])

            }

        }
    }

}