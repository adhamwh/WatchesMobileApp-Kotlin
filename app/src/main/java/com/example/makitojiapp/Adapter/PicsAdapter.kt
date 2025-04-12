package com.example.makitojiapp.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.makitojiapp.R
import com.example.makitojiapp.databinding.ViewholderPicBinding
import com.example.makitojiapp.databinding.ViewholderPopularBinding

class PicsAdapter(val items:MutableList<String>,val onImageSelected:(String)->Unit):
RecyclerView.Adapter<PicsAdapter.Viewholder>(
) {
    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    class Viewholder(val binding: ViewholderPicBinding):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
       val binding=ViewholderPicBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, @SuppressLint("RecyclerView") position:Int){
        val item = items[position]
        holder.binding.pic.loadImage(item)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            onImageSelected(item)

        }
        if (selectedPosition == position) {
            holder.binding.picLayout.setBackgroundResource(R.drawable.orange_stroke_bg)
        } else {
            holder.binding.picLayout.setBackgroundResource(R.drawable.grey_stroke_bg)
        }
    }

    fun ImageView.loadImage(url:String){
        Glide.with(this.context)
            .load(url)
            .into(this)
    }

    override fun getItemCount(): Int = items.size
}