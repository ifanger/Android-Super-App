package com.ifanger.home.router

import android.content.Context
import android.content.Intent
import com.ifanger.home.presentation.home.HomeActivity
import com.ifanger.router.home.HomeRouter

internal class HomeRouterImpl : HomeRouter {

    override fun getHomeActivity(context: Context): Intent {
        return Intent(context, HomeActivity::class.java)
    }
}