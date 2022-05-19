package com.example.repaso_examen_final.nav_drawer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModelNavDrawer : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home in Navigation Drawer Fragment"
    }
    val text: LiveData<String> = _text
}