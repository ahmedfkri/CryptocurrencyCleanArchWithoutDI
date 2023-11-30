package com.example.cryptocurrencycleanarch.domain.model

import java.io.Serializable

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
){
}