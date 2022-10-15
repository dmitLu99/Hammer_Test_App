package com.example.hammertestapp.feature_menu_screen.data.storage.models.daos

import androidx.room.*
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.YumsEntity

@Dao internal interface YumsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertYums(yums: YumsEntity)

    @Delete fun deleteYums(yums: YumsEntity)

    @Query("SELECT * FROM YumsEntity") fun getYumses(): List<YumsEntity>
}