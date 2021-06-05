package com.example.ai_timelapse_wallpaper.ui.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.data.local.SharedPref
import com.example.ai_timelapse_wallpaper.data.local.Singleton
import com.example.ai_timelapse_wallpaper.databinding.ActivitySettingBinding
import com.example.ai_timelapse_wallpaper.ui.loading.LoadingActivity
import com.example.ai_timelapse_wallpaper.util.MyDummyRecyclerViewAdapter
import kotlinx.android.synthetic.main.layout_button.view.*
import kotlinx.android.synthetic.main.layout_viewpager_item.*

class SettingActivity : AppCompatActivity() {

    private val PICTURE_REQUEST_CODE = 1498

    lateinit var binding : ActivitySettingBinding

    lateinit var viewModel : SettingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)

        viewModel.adapter = MyDummyRecyclerViewAdapter(viewModel.getDummyList(applicationContext))

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting)

        with(binding){
            activity = this@SettingActivity
            vm = viewModel
            lifecycleOwner = this@SettingActivity

            initRecyclerView(binding)

            initMyGallery(binding.buttonMyGallerySettingActivity as LinearLayout)
            initRecommended(binding.buttonRecommendSettingActivity as LinearLayout)

            invalidateAll()
        }
    }

    fun initMyGallery(view: LinearLayout) {
        with(view){
            textView_ButtonText_ButtonLayout.text = "My Gallery"

            setOnClickListener {
                openGallery()
            }
        }
    }

    fun initRecommended(view: LinearLayout) {
        with(view){
            textView_ButtonText_ButtonLayout.text = "Recommend"

            setOnClickListener {
                suggestSampleImages()
            }
        }
    }

    //미구현
    private fun suggestSampleImages(){
        Toast.makeText(baseContext, "아직 구현중인 기능입니다", Toast.LENGTH_SHORT).show()
    }


//    //사진 1장만 가져오는 함수
//    private fun openGallery() {
//        // 암시적 인텐트로 갤러리 열기
//        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//        startActivityForResult(gallery, 100)
//    }

    //Test용 사진 여러 장 가져오는 함수
    private fun openGallery(){
        // 암시적 인텐트로 갤러리 열기
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        //Intent.createChooser 어디에서 사진을 고를건지 선택하게 해줌(갤러리, 포토, 클라우드)

        startActivityForResult(Intent.createChooser(intent, "배경화면 선택"), PICTURE_REQUEST_CODE)
    }

    fun initRecyclerView(binding: ActivitySettingBinding) {

        binding.recyclerViewSettingActivity.adapter = viewModel.adapter

        viewModel.adapter.notifyDataSetChanged()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == PICTURE_REQUEST_CODE && resultCode == RESULT_OK){
            getImages(data)
            startActivity(Intent(this, LoadingActivity::class.java))
        }

    }

    private fun getImages(data: Intent?){
        //val imageUri : Uri? = data?.data

        val clipData = data?.clipData

        var arr = ArrayList<Uri>()
        for (i in 0 until Singleton.IMG_ARR_SIZE){
            arr.add(clipData!!.getItemAt(i).uri)
        }

        Singleton.imageUriArr = arr
        SharedPref(this).saveImageArr(arr)
    }
}