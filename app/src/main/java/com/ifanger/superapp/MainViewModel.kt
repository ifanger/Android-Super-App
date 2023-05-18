package com.ifanger.superapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifanger.market.domain.model.MarketItem
import com.ifanger.market.domain.usecase.MarketItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val marketItemUseCase: MarketItemUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = marketItemUseCase.getAll()

            withContext(Dispatchers.Main) {
                _state.value = State.Success(result)
            }
        }
    }

    sealed interface State {
        object Loading : State
        data class Success(val items: List<MarketItem>) : State
    }
}