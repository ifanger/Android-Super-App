package com.ifanger.designsystem.components.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.ifanger.designsystem.ui.theme.SuperAppTheme

abstract class BaseActivity : ComponentActivity() {

    @Composable
    abstract fun Content()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SuperAppTheme {
                Content()
            }
        }
    }
}