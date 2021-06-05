package com.example.ai_timelapse_wallpaper.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ai_timelapse_wallpaper.R


class MyRecyclerViewAdapter(private val dataList: ArrayList<Bitmap>): RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_recyclerview_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, itemPosition: Int) {
        holder.bindItemStatusListItems(dataList[itemPosition])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindItemStatusListItems(data: Bitmap){

            itemView.findViewById<ImageView>(R.id.imageView_RecyclerViewItem).setImageBitmap(data)

            Glide.with(itemView).load(data).into(itemView.findViewById<ImageView>(R.id.imageView_RecyclerViewItem))
        }
    }

}

