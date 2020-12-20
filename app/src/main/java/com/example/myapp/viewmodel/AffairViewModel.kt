package com.example.myapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.AffairDao
import com.example.myapp.repository.AffairRepository
import com.example.myapp.model.Affair
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AffairViewModel(val database: AffairDao, application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Affair>>
    private val repository: AffairRepository

    init {
        repository = AffairRepository(database)
        readAllData = repository.readAllData
    }

    fun addAffair(affair: Affair){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAffair(affair)
        }
    }

    fun updateAffair(affair: Affair){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAffair(affair)
        }
    }

    fun deleteAffair(affair: Affair){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAffair(affair)
        }
    }

    fun deleteAllAffair(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAffair()
        }
    }

}