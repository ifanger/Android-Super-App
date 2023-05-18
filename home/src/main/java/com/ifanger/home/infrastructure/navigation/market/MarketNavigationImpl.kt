package com.ifanger.home.infrastructure.navigation.market

import android.content.Context
import android.content.Intent
import com.ifanger.router.market.MarketRouter

internal class MarketNavigationImpl(
    private val context: Context,
    private val marketRouter: MarketRouter,
) : MarketNavigation {

    override fun createItem(): Intent {
        return marketRouter.getCreateItem(context)
    }
}