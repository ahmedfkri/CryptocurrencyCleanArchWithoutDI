package com.example.cryptocurrencycleanarch.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencycleanarch.data.remote.dto.TeamMember
import com.example.cryptocurrencycleanarch.databinding.TeamMemberListItemBinding

class TeamMembersAdapter : RecyclerView.Adapter<TeamMembersAdapter.MemberViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<TeamMember>() {
        override fun areItemsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    inner class MemberViewHolder(val binding: TeamMemberListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        return MemberViewHolder(
            TeamMemberListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()= differ.currentList.size

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val currentMember = differ.currentList[position]
        holder.binding.txtMemberName.text=currentMember.name
        holder.binding.txtMemberPosition.text=currentMember.position
    }
}