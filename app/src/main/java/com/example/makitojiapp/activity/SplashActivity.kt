package com.example.makitojiapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.makitojiapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var bingind:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bingind=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bingind.root)

        bingind.startBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}