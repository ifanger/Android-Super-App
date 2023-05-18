package com.ifanger.home.presentation.home

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ifanger.designsystem.components.activity.BaseActivity
import com.ifanger.home.infrastructure.navigation.market.MarketNavigation
import com.ifanger.home.presentation.home.composable.MarketCard
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class HomeActivity : BaseActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private val marketNavigation: MarketNavigation by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMarketItems()
    }

    @Composable
    override fun Content() {
        val state by viewModel.state.collectAsState()

        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                when (state) {
                    is HomeViewModel.HomeState.Loading -> {
                        Text(text = "Loading")
                    }

                    is HomeViewModel.HomeState.Success -> {
                        val items = (state as HomeViewModel.HomeState.Success).marketItems
                        MarketCard(
                            onNewItemClick = {
                                startActivity(marketNavigation.createItem())
                            },
                            marketItems = items,
                        )
                    }

                    is HomeViewModel.HomeState.Error -> {
                        Text(text = "Error")
                    }
                }
            }
        }
    }
}
