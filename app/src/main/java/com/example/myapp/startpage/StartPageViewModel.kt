package com.example.myapp.startpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartPageViewModel : ViewModel() {

    private val _edit = MutableLiveData<String>()
    val edit : LiveData<String>
        get() = _edit


}