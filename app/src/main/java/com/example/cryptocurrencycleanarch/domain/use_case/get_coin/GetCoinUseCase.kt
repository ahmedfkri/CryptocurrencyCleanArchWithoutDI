package com.example.cryptocurrencycleanarch.domain.use_case.get_coin

import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.data.remote.dto.toCoin
import com.example.cryptocurrencycleanarch.data.remote.dto.toCoinDetail
import com.example.cryptocurrencycleanarch.domain.model.Coin
import com.example.cryptocurrencycleanarch.domain.model.CoinDetail
import com.example.cryptocurrencycleanarch.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        }catch (e: HttpException){
            emit(Resource.Error(e.message() ?: "Error"))

        }catch (e: IOException){
            emit(Resource.Error( "Couldn't reach server"))
        }
    }
}