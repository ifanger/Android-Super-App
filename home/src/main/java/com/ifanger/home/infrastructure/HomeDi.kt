package com.ifanger.home.infrastructure

import android.content.Context
import com.ifanger.core.infrastructure.di.BaseDi
import com.ifanger.home.infrastructure.navigation.market.MarketNavigation
import com.ifanger.home.infrastructure.navigation.market.MarketNavigationImpl
import com.ifanger.home.presentation.home.HomeViewModel
import com.ifanger.home.router.HomeRouterImpl
import com.ifanger.router.home.HomeRouter
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class HomeDi : BaseDi() {

    override val module: Module = module {
        factoryOf<HomeRouter>(::HomeRouterImpl)
        factory<MarketNavigation> { (context: Context) ->
            MarketNavigationImpl(
                context = context,
                marketRouter = get(),
            )
        }

        viewModelOf(::HomeViewModel)
    }
}