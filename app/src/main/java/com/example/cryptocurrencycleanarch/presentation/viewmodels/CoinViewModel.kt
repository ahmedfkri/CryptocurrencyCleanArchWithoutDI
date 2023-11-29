package com.example.cryptocurrencycleanarch.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.domain.model.Coin
import com.example.cryptocurrencycleanarch.domain.model.CoinDetail
import com.example.cryptocurrencycleanarch.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptocurrencycleanarch.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.Flow

class CoinViewModel(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getCoinUseCase: GetCoinUseCase
): ViewModel() {

    fun getCoinByID(coinId:String): Flow<Resource<CoinDetail>> {
        return getCoinUseCase(coinId)
    }

    fun getCoins():Flow<Resource<List<Coin>>>{
        return getCoinsUseCase()
    }

}