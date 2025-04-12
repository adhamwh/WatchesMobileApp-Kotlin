package com.example.makitojiapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.makitojiapp.Domain.BannerModel
import com.example.makitojiapp.Domain.CategoryModel
import com.example.makitojiapp.Domain.ItemsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Error

class MainRepository {
    private val firebaseDatabase=FirebaseDatabase.getInstance()

    fun loadBanner():LiveData<MutableList<BannerModel>>{
        val liveData=MutableLiveData<MutableList<BannerModel>>()
        val ref=firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object :ValueEventListener{
            override fun  onDataChange(snapshot: DataSnapshot){
                val list= mutableListOf<BannerModel>()
                for(childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(BannerModel::class.java)
                    item?.let { list.add(it) }
                }
                liveData.value=list
            }
            override fun onCancelled(error: DatabaseError){

            }
        })
        return liveData
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        val liveData=MutableLiveData<MutableList<CategoryModel>>()
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object :ValueEventListener{
            override fun  onDataChange(snapshot: DataSnapshot){
                val list= mutableListOf<CategoryModel>()
                for(childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(CategoryModel::class.java)
                    item?.let { list.add(it) }
                }
                liveData.value=list
            }
            override fun onCancelled(error: DatabaseError){

            }
        })
        return liveData
    }



    fun loadPopular():LiveData<MutableList<ItemsModel>>{
        val liveData=MutableLiveData<MutableList<ItemsModel>>()
        val ref=firebaseDatabase.getReference("Popular")
        ref.addValueEventListener(object :ValueEventListener{
            override fun  onDataChange(snapshot: DataSnapshot){
                val list= mutableListOf<ItemsModel>()
                for(childSnapshot in snapshot.children){
                    val item=childSnapshot.getValue(ItemsModel::class.java)
                    item?.let { list.add(it) }
                }
                liveData.value=list
            }
            override fun onCancelled(error: DatabaseError){

            }
        })
        return liveData
    }

}