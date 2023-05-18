package com.ifanger.superapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.ifanger.superapp.ui.theme.SuperAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.load()

        setContent {
            SuperAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val state = viewModel.state.collectAsState()

                    when (val currentState = state.value) {
                        is MainViewModel.State.Loading -> {
                            Text(text = "Loading...")
                        }

                        is MainViewModel.State.Success -> {
                            Text(text = "Success: ${currentState.items}")
                        }
                    }
                }
            }
        }
    }
}