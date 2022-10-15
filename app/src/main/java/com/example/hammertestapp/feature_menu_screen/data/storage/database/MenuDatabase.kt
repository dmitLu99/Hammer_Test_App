package com.example.hammertestapp.feature_menu_screen.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hammertestapp.feature_menu_screen.data.storage.models.daos.ContentDao
import com.example.hammertestapp.feature_menu_screen.data.storage.models.daos.DisplayItemDao
import com.example.hammertestapp.feature_menu_screen.data.storage.models.daos.FeedDao
import com.example.hammertestapp.feature_menu_screen.data.storage.models.daos.YumsDao
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.ContentEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.DisplayItemEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.FeedEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.models.entities.YumsEntity
import com.example.hammertestapp.feature_menu_screen.data.storage.type_converters.StringListConverter

@[Database(
    entities = [
        ContentEntity::class, DisplayItemEntity::class, FeedEntity::class, YumsEntity::class
    ],version = 1,
) TypeConverters(StringListConverter::class)] internal abstract class MenuDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao
    abstract fun displayItemDao(): DisplayItemDao
    abstract fun feedDao(): FeedDao
    abstract fun yumsDao(): YumsDao
}