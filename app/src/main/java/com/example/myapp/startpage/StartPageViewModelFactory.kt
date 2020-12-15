package com.example.myapp.startpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.startpage.StartPageViewModel
import java.lang.IllegalArgumentException

class StartPageViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StartPageViewModel::class.java)) {
            return StartPageViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}