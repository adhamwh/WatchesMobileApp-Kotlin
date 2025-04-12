package com.example.makitojiapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.makitojiapp.Adapter.PicsAdapter
import com.example.makitojiapp.Domain.ItemsModel
import com.example.makitojiapp.R
import com.example.makitojiapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item:ItemsModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle()
        initList()
    }

    private fun initList() {
        val picList = ArrayList<String>()
        for (imageUrl in item.picUrl){
            picList.add(imageUrl)
        }

        Glide.with(this)
            .load(picList[0])
            .into(binding.img)

        binding.picList.adapter = PicsAdapter(picList){selectedImageUrl->
            Glide.with(this)
                .load(selectedImageUrl)
                .into(binding.img)
        }
        binding.picList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun bundle() {
        binding.apply {
            item=intent.getSerializableExtra("object") as ItemsModel

            Glide.with(this@DetailActivity)
                .load(item.picUrl[0])
                .into(binding.img)

            titleTxt.text=item.title
            descriptionTxt.text=item.description
            priceTxt.text="$"+item.price
            ratingTxt.text=item.rating.toString()

            backBtn.setOnClickListener{ finish() }
        }
    }

}