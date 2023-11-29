package com.example.cryptocurrencycleanarch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencycleanarch.databinding.CoinListItemBinding
import com.example.cryptocurrencycleanarch.domain.model.Coin

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {


    private val differCallback = object : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    class CoinViewHolder(private val binding: CoinListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: Coin, onItemClickListener: (Coin)-> Unit) {
            binding.apply {
                txtName.text = coin.name
                txtRank.text = coin.rank.toString()
                txtSymbol.text = coin.symbol
                root.setOnClickListener {
                    onItemClickListener(coin)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            CoinListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = differ.currentList[position]
        holder.bind(coin, onItemClickListener!!)
    }


    override fun getItemCount() = differ.currentList.size

    private var onItemClickListener: ((Coin) -> Unit)? = null

    fun setOnItemClickListener(listener: (Coin) -> Unit) {
        onItemClickListener = listener

    }


}