package com.example.cryptocurrencycleanarch.domain.model

import com.example.cryptocurrencycleanarch.data.remote.dto.Links
import com.example.cryptocurrencycleanarch.data.remote.dto.LinksExtended
import com.example.cryptocurrencycleanarch.data.remote.dto.Tag
import com.example.cryptocurrencycleanarch.data.remote.dto.TeamMembers
import com.example.cryptocurrencycleanarch.data.remote.dto.Whitepaper

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMembers>,
    )