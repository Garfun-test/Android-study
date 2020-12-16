package com.example.myapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapp.model.Affair

@Dao
interface AffairDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAffair(affair: Affair)

    @Update
    fun updateAffair(affair: Affair)

    @Delete
    fun deleteAffair(affair: Affair)

    @Query("DELETE FROM affair_table")
    fun deleteAllAffair()

    @Query("SELECT * FROM affair_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Affair>>

}