package com.example.cryptocurrencycleanarch.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cryptocurrencycleanarch.R
import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.data.remote.CoinPaprikaApi
import com.example.cryptocurrencycleanarch.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencycleanarch.databinding.ActivityMainBinding
import com.example.cryptocurrencycleanarch.domain.repository.CoinRepository
import com.example.cryptocurrencycleanarch.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptocurrencycleanarch.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptocurrencycleanarch.presentation.viewmodels.CoinViewModel
import com.example.cryptocurrencycleanarch.presentation.viewmodels.CoinViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api: CoinPaprikaApi
        val coinRepo = CoinRepositoryImpl()
        val getCoinUseCase = GetCoinUseCase(coinRepo)
        val getCoinsUseCase = GetCoinsUseCase(coinRepo)
        val coinViewModelFactory = CoinViewModelFactory(getCoinsUseCase, getCoinUseCase)
        viewModel = ViewModelProvider(this, coinViewModelFactory)
            .get(CoinViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewModel.getCoinByID("btc-bitcoin").collect(){resource->
                when(resource){
                    is Resource.Success ->{
                        val coin = resource.data?.name ?: "Unkwon"
                        binding.txtName.text=coin

                    }
                    is Resource.Error ->{
                        Toast.makeText(this@MainActivity, resource.message, Toast.LENGTH_SHORT).show()
                    }

                    else -> {

                    }
                }

            }
        }

    }
}