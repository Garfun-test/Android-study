package com.example.myapp.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.todolist.ToDoListViewModel
import java.lang.IllegalArgumentException

class ToDoListViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ToDoListViewModel::class.java)) {
            return ToDoListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}