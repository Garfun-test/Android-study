package com.example.myapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "affair_table")
data class Affair(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val affair: String,
    val status: String
): Parcelable