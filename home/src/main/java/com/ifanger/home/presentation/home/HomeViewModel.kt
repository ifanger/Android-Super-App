package com.ifanger.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifanger.market.model.MarketItem
import com.ifanger.market.usecase.MarketItemUseCase
import java.lang.Exception
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class HomeViewModel(
    private val marketItemUseCase: MarketItemUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    private val _action = MutableSharedFlow<HomeAction>()
    val action = _action.asSharedFlow()

    fun getMarketItems() {
        try {
            _state.value = HomeState.Loading

            viewModelScope.launch(Dispatchers.IO) {
                val marketItems = marketItemUseCase.getAll()

                withContext(Dispatchers.Main) {
                    _state.value = HomeState.Success(marketItems)
                }
            }
        } catch (e: Exception) {
            _state.value = HomeState.Error(e.message ?: "Erro desconhecido")
        }
    }

    fun openCreateMarketItem() {
        _action.tryEmit(HomeAction.CreateMarketItem)
    }

    sealed interface HomeState {
        object Loading : HomeState
        data class Success(val marketItems: List<MarketItem>) : HomeState
        data class Error(val message: String) : HomeState
    }

    sealed interface HomeAction {
        object CreateMarketItem : HomeAction
    }
}