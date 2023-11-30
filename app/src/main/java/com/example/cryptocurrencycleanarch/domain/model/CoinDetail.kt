package com.example.cryptocurrencycleanarch.domain.model

import com.example.cryptocurrencycleanarch.data.remote.dto.TeamMember

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,
    )