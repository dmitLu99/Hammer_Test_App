package com.example.hammertestapp.feature_menu_screen.data.storage.models.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.ContentEntity

@Dao internal interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertContent(content: ContentEntity)

    @Delete fun deleteContent(content: ContentEntity)

    @Query("SELECT * FROM ContentEntity") fun getAllContent(): List<ContentEntity>
}