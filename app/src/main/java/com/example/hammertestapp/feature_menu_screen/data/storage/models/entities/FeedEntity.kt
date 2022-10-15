package com.example.hammertestapp.feature_menu_screen.data.storage.models.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity internal data class FeedEntity(
    @[PrimaryKey(autoGenerate = true) ColumnInfo(name = "feed_id")] val id: Int,
    @Embedded val display: DisplayItemEntity,
    @Embedded val content: ContentEntity
)