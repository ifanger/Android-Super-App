package com.ifanger.superapp

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ifanger.designsystem.components.activity.BaseActivity
import com.ifanger.router.home.HomeRouter
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {

    private val homeRouter: HomeRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startHomeActivity()
    }

    private fun startHomeActivity() {
        homeRouter.getHomeActivity(this).run {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(this)
        }
    }

    @Composable
    override fun Content() {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(text = "Hello World!",)
        }
    }
}