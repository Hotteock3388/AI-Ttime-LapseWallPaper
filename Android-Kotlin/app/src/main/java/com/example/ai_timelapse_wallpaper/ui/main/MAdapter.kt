package com.example.ai_timelapse_wallpaper.ui.main

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.data.local.Singleton
import kotlinx.android.synthetic.main.layout_viewpager_item.view.*

class MAdapter(private val dataList: ArrayList<Uri>): RecyclerView.Adapter<MAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return Singleton.imageUriArr.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_viewpager_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, itemPosition: Int) {
        holder.bindItemStatusListItems(Singleton.imageUriArr[itemPosition])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItemStatusListItems(data: Uri){
            itemView.imageView_ViewPagerItem.setImageURI(data)
        }
    }
}
