package com.ifanger.superapp.di

import com.ifanger.home.infrastructure.HomeDi
import com.ifanger.market.impl.infrastructure.MarketDi
import org.koin.core.module.Module

internal class DependencyInjection {

    val modules
        get(): List<Module> = listOf(
            HomeDi().module,
            MarketDi().module,
        )
}