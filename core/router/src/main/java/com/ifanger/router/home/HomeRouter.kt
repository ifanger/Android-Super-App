package com.ifanger.router.home

import android.content.Context
import android.content.Intent

interface HomeRouter {
    fun getHomeActivity(context: Context): Intent
}