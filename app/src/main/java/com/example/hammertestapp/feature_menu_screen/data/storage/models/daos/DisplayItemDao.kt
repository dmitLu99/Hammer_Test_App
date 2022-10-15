package com.example.hammertestapp.feature_menu_screen.data.storage.models.daos

import androidx.room.*
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.DisplayItemEntity

@Dao internal interface DisplayItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertDisplayItem(displayItem: DisplayItemEntity)

    @Delete fun deleteDisplayItem(displayItem: DisplayItemEntity)

    @Query("SELECT * FROM DisplayItemEntity") fun getDisplayItems(): List<DisplayItemEntity>
}