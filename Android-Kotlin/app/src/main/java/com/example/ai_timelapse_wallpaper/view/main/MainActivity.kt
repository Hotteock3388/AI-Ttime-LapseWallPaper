package com.example.ai_timelapse_wallpaper.view.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.databinding.ActivityMainBinding
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.view.setting.SettingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class   MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel : MainViewModel by viewModel()

    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.imageSettingButtonClick.observe(this, {
            startActivity(Intent(this, SettingActivity::class.java))
        })

        //ViewPager Adapter 초기화
        viewModel.adapter.also {
            binding.viewPagerMainActivity.adapter = it
        }.notifyDataSetChanged()

    }

    override fun onBackPressed() {
        //1번 눌렀을 때
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        //2초 안에 2번 눌렀을 때 종료
        else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish()
        }
    }
}
