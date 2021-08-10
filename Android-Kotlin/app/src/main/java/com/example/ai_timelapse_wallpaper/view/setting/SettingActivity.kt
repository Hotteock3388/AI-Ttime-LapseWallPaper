package com.example.ai_timelapse_wallpaper.view.setting

import android.content.Intent
import android.os.Bundle
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.databinding.ActivitySettingBinding
import com.example.ai_timelapse_wallpaper.view.apply.ApplyActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity<ActivitySettingBinding, SettingViewModel>(R.layout.activity_setting) {

    override val viewModel : SettingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()

        viewModel.clickRecommend.observe(this, {
            suggestSampleImages()
        })

        viewModel.clickMyGallery.observe(this, {
            viewModel.openGallery()
        })

        viewModel.galleryIntent.observe(this, {
            startActivityForResult(Intent.createChooser(viewModel.galleryIntent.value, "배경화면 선택"), 1423)
            //launcher.launch(viewModel.galleryIntent.value)
        })

        viewModel.saveComplete.observe(this, {
            startLoading()
        })

        viewModel.finish.observe(this, {
            finish()
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            viewModel.saveSelectedImage(contentResolver ,data)
        }
    }

    private fun initRecyclerView() {
        viewModel.adapter.also {
            binding.recyclerViewSettingActivity.adapter = it
        }.notifyDataSetChanged()
    }

    //미구현
    private fun suggestSampleImages(){
        showToast("아직 구현중인 기능입니다")
    }

    private fun startLoading(){
        finish()
        //원래 서버 LoadingActivity에서 서버 통신 해야하지만 테스트 중이니 로딩 패스
        //startActivity(Intent(this, LoadingActivity::class.java))
        startActivity(Intent(this, ApplyActivity::class.java))
    }


}