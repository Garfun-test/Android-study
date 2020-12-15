package com.example.myapp.addaffairs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AddAffairsViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddAffairsViewModel::class.java)) {
            return AddAffairsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}