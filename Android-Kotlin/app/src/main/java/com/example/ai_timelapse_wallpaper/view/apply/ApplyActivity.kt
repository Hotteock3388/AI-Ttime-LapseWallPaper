package com.example.ai_timelapse_wallpaper.view.apply

import android.content.Intent
import android.os.Bundle
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.databinding.ActivityApplyBinding
import com.example.ai_timelapse_wallpaper.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply) {

    override val viewModel: ApplyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //RecyclerView Adapter 초기화
        viewModel.adapter.also {
            binding.recyclerViewApplyActivity.adapter = it
        }.notifyDataSetChanged()

        //적용 완료 or 취소
        viewModel.fin.observe(this, {
            gotoMainActivity(it)
        })

    }

    private fun gotoMainActivity(msg: String){
        showToast(msg)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}