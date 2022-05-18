package com.example.repaso_examen_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.view.isGone
import androidx.lifecycle.Lifecycle
import com.example.repaso_examen_final.bottom_nav.BottomNavActivity
import com.example.repaso_examen_final.databinding.ActivityMainBinding
import com.example.repaso_examen_final.nav_drawer.NavDrawer
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBtmNav.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    BottomNavActivity::class.java
                )
            )
        }
        binding.btnNavDrawer.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    NavDrawer::class.java
                )
            )
        }

    }


}