package com.example.ai_timelapse_wallpaper.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.databinding.ActivityMainBinding
import com.example.ai_timelapse_wallpaper.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    
    lateinit var binding: ActivityMainBinding

    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //DataBinding 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //ViewModel 초기화
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //ViewPager Adapter 초기화
        viewModel.adapter = MAdapter(viewModel.getBitmapImageList())

        with(binding){
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity
            vm = viewModel
            binding.viewPagerMainActivity.adapter = viewModel.adapter
        }

        viewModel.adapter.notifyDataSetChanged()
    }

    fun imageSetting(){
        viewModel.adapter.notifyDataSetChanged()
        startActivity(Intent(this, SettingActivity::class.java))
    }

    fun viewPagerPrevPage(){
        if(binding.viewPagerMainActivity.currentItem != 0){
            binding.viewPagerMainActivity.currentItem--
        }
    }

    fun viewPagerNextPage(){
        if(binding.viewPagerMainActivity.currentItem != viewModel.getBitmapImageList().size - 1){
            binding.viewPagerMainActivity.currentItem++
        }
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