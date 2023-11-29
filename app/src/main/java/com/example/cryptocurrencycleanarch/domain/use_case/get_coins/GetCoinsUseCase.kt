package com.example.cryptocurrencycleanarch.domain.use_case.get_coins

import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.data.remote.dto.toCoin
import com.example.cryptocurrencycleanarch.domain.model.Coin
import com.example.cryptocurrencycleanarch.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        }catch (e: HttpException){
            emit(Resource.Error(e.message() ?: "Error"))

        }catch (e: IOException){
            emit(Resource.Error( "Couldn't reach server"))
        }
    }
}