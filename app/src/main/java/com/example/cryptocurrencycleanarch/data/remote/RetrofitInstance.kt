package com.example.cryptocurrencycleanarch.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    companion object{
        private val retrofit by lazy{
            Retrofit.Builder()
                .baseUrl("https://api.coinpaprika.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

         val api by lazy{
            retrofit.create(CoinPaprikaApi::class.java)
        }
    }

}