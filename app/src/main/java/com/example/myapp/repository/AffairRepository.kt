package com.example.myapp.repository

import androidx.lifecycle.LiveData
import com.example.myapp.data.AffairDao
import com.example.myapp.model.Affair

class AffairRepository(private val affairDao: AffairDao) {

    val readAllData: LiveData<List<Affair>> = affairDao.readAllData()

    fun addAffair(affair: Affair){
        affairDao.addAffair(affair)
    }

    fun updateAffair(affair: Affair){
        affairDao.updateAffair(affair)
    }

    fun deleteAffair(affair: Affair){
        affairDao.deleteAffair(affair)
    }

    fun deleteAllAffair(){
        affairDao.deleteAllAffair()
    }

}