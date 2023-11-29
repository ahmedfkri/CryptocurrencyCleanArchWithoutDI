package com.example.cryptocurrencycleanarch.domain.repository

import com.example.cryptocurrencycleanarch.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencycleanarch.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto

}