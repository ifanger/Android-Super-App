package com.ifanger.home.presentation.home.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifanger.market.model.MarketItem

@Composable
fun MarketCard(
    onNewItemClick: () -> Unit,
    marketItems: List<MarketItem>,
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Lista de compras",
                style = MaterialTheme.typography.titleLarge,
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            )
        }
        AnimatedVisibility(
            visible = marketItems.isEmpty(),
        ) {
            Text(
                text = "Nenhum item na lista",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
            )
        }
        AnimatedVisibility(
            visible = marketItems.isNotEmpty(),
        ) {
            LazyColumn {
                items(marketItems.size) { index ->
                    Text(
                        text = marketItems[index].name,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),

            ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(fraction = .5f),
                onClick = {},
            ) {
                Text(text = "Ver lista")
            }
            Spacer(modifier = Modifier.width(16.dp))
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onNewItemClick,
            ) {
                Text(text = "Novo item")
            }
        }
    }
}

@Preview
@Composable
fun MarketCardPreview() {
    MarketCard(
        onNewItemClick = {},
        marketItems = emptyList()
    )
}