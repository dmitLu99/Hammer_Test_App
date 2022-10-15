package com.example.hammertestapp.feature_menu_screen.data.storage.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity internal data class YumsEntity(
    @[PrimaryKey(autoGenerate = true) ColumnInfo(name = "yums_id")] val id: Int,
    val price: Int
)