package com.example.ai_timelapse_wallpaper.ui.main

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ai_timelapse_wallpaper.R
import kotlinx.android.synthetic.main.layout_recyclerview_item.view.*
import kotlinx.android.synthetic.main.layout_viewpager_item.view.*

class MAdapter(private val dataList: ArrayList<Drawable>): RecyclerView.Adapter<MAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_viewpager_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, itemPosition: Int) {
        holder.bindItemStatusListItems(dataList[itemPosition])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItemStatusListItems(data: Drawable){
            itemView.imageView_ViewPagerItem.setImageDrawable(data)
        }
    }
}
