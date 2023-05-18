package com.ifanger.market.impl.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ifanger.market.impl.model.entity.MarketItemEntity

@Dao
internal interface MarketItemDao {
    @Query("SELECT * FROM market_items")
    fun getAll(): List<MarketItemEntity>

    @Query("SELECT * FROM market_items WHERE id = :id")
    fun getById(id: Long): MarketItemEntity?

    @Insert
    fun insertAll(vararg items: MarketItemEntity)

    @Update
    fun update(item: MarketItemEntity)

    @Query("DELETE FROM market_items WHERE id = :id")
    fun delete(id: Long)
}