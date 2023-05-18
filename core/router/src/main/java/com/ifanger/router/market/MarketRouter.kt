package com.ifanger.router.market

import android.content.Context
import android.content.Intent

interface MarketRouter {
    fun getCreateItem(context: Context): Intent
    fun getItemList(context: Context): Intent
}