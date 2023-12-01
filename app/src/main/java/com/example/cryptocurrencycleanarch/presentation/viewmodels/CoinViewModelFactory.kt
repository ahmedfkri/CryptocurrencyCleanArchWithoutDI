package com.example.cryptocurrencycleanarch.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocurrencycleanarch.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptocurrencycleanarch.domain.use_case.get_coins.GetCoinsUseCase

class CoinViewModelFactory(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getCoinUseCase: GetCoinUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoinViewModel(getCoinsUseCase, getCoinUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}