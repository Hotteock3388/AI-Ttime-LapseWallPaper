package com.example.ai_timelapse_wallpaper.view.setting

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.base.BaseViewModel
import com.example.ai_timelapse_wallpaper.model.local.Singleton
import com.example.ai_timelapse_wallpaper.util.MyDummyRecyclerViewAdapter
import com.example.ai_timelapse_wallpaper.util.MyUtil
import com.example.ai_timelapse_wallpaper.view.main.MAdapter

class SettingViewModel: BaseViewModel() {

    private val PICTURE_REQUEST_CODE = 1498

    var clickMyGallery = MutableLiveData<Unit>()
    var clickRecommend = MutableLiveData<Unit>()

    var galleryIntent = MutableLiveData<Intent>()

    var saveComplete = MutableLiveData<Unit>()

    var finish = MutableLiveData<Unit>()

    var adapter = MAdapter(getBitmapImageList())

    fun getBitmapImageList(): ArrayList<Bitmap> {
        return Singleton.imageArr.value!!
    }

    fun finish() { finish.value = Unit }

    //사진 1장만 가져오는 함수
//    private fun openGallery() {
//        // 암시적 인텐트로 갤러리 열기
//        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
//        galleryIntent.value = intent
//    }

    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        galleryIntent.value = intent
    //galleryIntent.value = Intent.createChooser(galleryIntent.value, "배경화면 선택", )

    }

    fun saveSelectedImage(contentResolver: ContentResolver, data: Intent?){
        val bitmapArr = ArrayList<Bitmap>()

        data?.clipData.let {
            for (i in 0 until it?.itemCount!!) {
                bitmapArr.add(MediaStore.Images.Media.getBitmap(contentResolver, it.getItemAt(i).uri))
            }
        }

        Singleton.selectedImageArr = bitmapArr

        saveComplete.value = Unit
    }

}