package com.example.myapp.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoListViewModel : ViewModel() {

    private val _list = MutableLiveData<String>()
    val list : LiveData<String>
        get() = _list
}