package com.example.hammertestapp.feature_menu_screen.data.storage.models.daos

import androidx.room.*
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity

@Dao internal interface FeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertFeed(feed: FeedEntity)

    @Delete fun deleteFeed(content: FeedEntity)

    @Query("SELECT * FROM FeedEntity") fun getFeeds(): List<FeedEntity>
}