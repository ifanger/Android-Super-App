package com.ifanger.market.impl.infrastructure.router

import android.content.Context
import android.content.Intent
import com.ifanger.market.impl.presentation.item.create.CreateMarketItemActivity
import com.ifanger.router.market.MarketRouter

internal class MarketRouterImpl : MarketRouter {

    override fun getCreateItem(context: Context): Intent {
        return Intent(context, CreateMarketItemActivity::class.java)
    }

    override fun getItemList(context: Context): Intent {
        TODO("Not yet implemented")
    }
}