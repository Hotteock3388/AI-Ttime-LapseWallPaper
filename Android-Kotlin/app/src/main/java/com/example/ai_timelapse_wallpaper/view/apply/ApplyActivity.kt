package com.example.ai_timelapse_wallpaper.view.apply

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseActivity
import com.example.ai_timelapse_wallpaper.databinding.ActivityApplyBinding
import com.example.ai_timelapse_wallpaper.model.local.SharedPref
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.view.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyActivity : BaseActivity<ActivityApplyBinding, ApplyViewModel>(R.layout.activity_apply) {

    override val viewModel: ApplyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //RecyclerView Adapter 초기화
        viewModel.adapter.also {
            binding.viewPager2ApplyActivity.adapter = it
        }.notifyDataSetChanged()

        //적용 완료 or 취소
        viewModel.apply.observe(this, {

            val arr = ArrayList<Bitmap>()
            showLog("${Singleton.selectedImageArr.size}")
            Singleton.processedImageArr.clear()

            for(i in 0 until Singleton.selectedImageArr.size){
                with(binding.imageViewProcessApplyActivity){
                    setImageBitmap(Singleton.selectedImageArr[i])
                    buildDrawingCache()
                    isDrawingCacheEnabled = true
                    Singleton.processedImageArr.add(Bitmap.createBitmap(drawingCache))
                }
            }

            SharedPref(baseContext).saveBitmapImageArr(Singleton.processedImageArr)
            //arr.add(binding.viewPager2ApplyActivity.get(i).imageView_ViewPagerItem.getDrawingCache(false))
            gotoMainActivity("적용 완료")
        })

        viewModel.cancel.observe(this, {
            gotoMainActivity("취소")
        })


    }

    private fun gotoMainActivity(msg: String){
        showToast(msg)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}