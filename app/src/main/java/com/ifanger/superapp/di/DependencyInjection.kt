package com.ifanger.superapp.di

import com.ifanger.market.impl.infrastructure.MarketDi
import com.ifanger.superapp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

internal class DependencyInjection {

    val modules
        get(): List<Module> = listOf(
            MarketDi().module,
            module {
                viewModelOf(::MainViewModel)
            },
        )
}