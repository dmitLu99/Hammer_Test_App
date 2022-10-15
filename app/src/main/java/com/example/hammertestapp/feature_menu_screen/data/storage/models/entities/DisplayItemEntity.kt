package com.example.hammertestapp.feature_menu_screen.data.storage.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity internal data class DisplayItemEntity(
    @[PrimaryKey(autoGenerate = true) ColumnInfo(name = "display_item_id")]  val id: Int,
    val displayName: String,
    val images: List<String>,
    val flag: String
)