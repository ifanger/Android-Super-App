package com.ifanger.market.impl.infrastructure

import androidx.room.Room
import com.ifanger.core.infrastructure.di.BaseDi
import com.ifanger.market.repository.ItemRepository
import com.ifanger.market.usecase.MarketItemUseCase
import com.ifanger.market.usecase.item.AddItemUseCase
import com.ifanger.market.usecase.item.DeleteItemUseCase
import com.ifanger.market.usecase.item.GetItemUseCase
import com.ifanger.market.usecase.item.GetItemsUseCase
import com.ifanger.market.usecase.item.UpdateItemUseCase
import com.ifanger.market.usecase.item.validator.ItemNameValidator
import com.ifanger.market.impl.infrastructure.room.MarketDatabase
import com.ifanger.market.impl.infrastructure.router.MarketRouterImpl
import com.ifanger.market.impl.repository.item.ItemRepositoryImpl
import com.ifanger.market.impl.repository.item.adapter.MarketItemEntityAdapter
import com.ifanger.router.market.MarketRouter
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class MarketDi : BaseDi() {

    override val module: Module = module {
        dataSource()
        repository()
        useCase()
        validator()
        adapter()
        router()
    }

    private fun Module.dataSource() {
        single {
            Room.databaseBuilder(androidContext(), MarketDatabase::class.java, "market-items").fallbackToDestructiveMigration()
                .build()
        }
        single { get<MarketDatabase>().itemsDao() }
    }

    private fun Module.repository() {
        single<ItemRepository> { ItemRepositoryImpl(get(), get()) }
    }

    private fun Module.useCase() {
        factoryOf(::MarketItemUseCase)
        factoryOf(::GetItemsUseCase)
        factoryOf(::GetItemUseCase)
        factoryOf(::AddItemUseCase)
        factoryOf(::UpdateItemUseCase)
        factoryOf(::DeleteItemUseCase)
    }

    private fun Module.validator() {
        factoryOf(::ItemNameValidator)
    }

    private fun Module.adapter() {
        factoryOf(::MarketItemEntityAdapter)
    }

    private fun Module.router() {
        factoryOf<MarketRouter>(::MarketRouterImpl)
    }
}