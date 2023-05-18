package com.ifanger.market.impl.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ifanger.market.impl.model.entity.MarketItemEntity

@Database(entities = [MarketItemEntity::class], version = 1, exportSchema = false)
internal abstract class MarketDatabase : RoomDatabase() {
    abstract fun itemsDao(): MarketItemDao
}