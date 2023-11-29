package com.example.cryptocurrencycleanarch.data.repository

import com.example.cryptocurrencycleanarch.data.remote.RetrofitInstance
import com.example.cryptocurrencycleanarch.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencycleanarch.data.remote.dto.CoinDto
import com.example.cryptocurrencycleanarch.domain.repository.CoinRepository

class CoinRepositoryImpl: CoinRepository {



    override suspend fun getCoins(): List<CoinDto> {
        return RetrofitInstance.api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return RetrofitInstance.api.getCoinById(coinId)
    }
}