package com.example.repaso_examen_final.ejercicios.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.example.repaso_examen_final.R
import com.example.repaso_examen_final.databinding.ActivityMainExamBinding
import com.example.repaso_examen_final.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
    }
}