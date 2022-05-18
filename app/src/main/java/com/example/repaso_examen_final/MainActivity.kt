package com.example.repaso_examen_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repaso_examen_final.bottom_nav.BottomNavActivity
import com.example.repaso_examen_final.databinding.ActivityMainBinding
import com.example.repaso_examen_final.ejercicios.ciclo_vida.CicloVidaActivity
import com.example.repaso_examen_final.nav_drawer.NavDrawer

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
        binding.btnCicloVida.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CicloVidaActivity::class.java
                )
            )
        }

    }


}