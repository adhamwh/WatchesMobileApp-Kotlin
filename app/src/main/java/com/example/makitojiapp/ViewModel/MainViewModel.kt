package com.example.makitojiapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.makitojiapp.Domain.BannerModel
import com.example.makitojiapp.Domain.CategoryModel
import com.example.makitojiapp.Domain.ItemsModel
import com.example.makitojiapp.Repository.MainRepository

class MainViewModel :ViewModel(){
    private val repository = MainRepository()

    fun loadBanner() : LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory() : LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular() : LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }

}