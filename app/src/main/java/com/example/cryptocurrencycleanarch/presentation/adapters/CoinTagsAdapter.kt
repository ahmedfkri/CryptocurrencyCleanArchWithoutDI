package com.example.cryptocurrencycleanarch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencycleanarch.databinding.TagListItemBinding

class CoinTagsAdapter : RecyclerView.Adapter<CoinTagsAdapter.TagViewHolder>() {

    var tagsList = emptyList<String>()




    inner class TagViewHolder ( val binding: TagListItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(
            TagListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = tagsList.size

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val currentTag = tagsList[position]
        holder.binding.txtTagName.text=currentTag
    }
}