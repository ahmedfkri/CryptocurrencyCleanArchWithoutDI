package com.example.cryptocurrencycleanarch.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.databinding.FragmentCoinDetailBinding
import com.example.cryptocurrencycleanarch.presentation.adapters.CoinTagsAdapter
import com.example.cryptocurrencycleanarch.presentation.adapters.TeamMembersAdapter
import com.example.cryptocurrencycleanarch.presentation.viewmodels.CoinViewModel
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.coroutines.launch


class CoinDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoinDetailBinding
    private lateinit var viewModel: CoinViewModel
    private lateinit var tagAdapter: CoinTagsAdapter
    private lateinit var membersAdapter: TeamMembersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        setupTagsRecyclerView()
        setupMembersRecyclerView()

        val coinId = arguments?.getString("coinId")

        lifecycleScope.launch {

            viewModel.getCoinByID(coinId.toString()).collect() { resource ->
                when (resource) {
                    is Resource.Success -> {
                        val coinDetail = resource.data
                        binding.apply {
                            txtName.text = coinDetail?.name ?: "UNKNOWN"
                            txtDesc.text = coinDetail?.description ?: "NO AVAILABLE DESCRIPTION"
                            txtIsActive.text = when (coinDetail?.is_active) {
                                true -> "active"
                                else -> "notActive"
                            }

                            val rank= coinDetail?.rank
                            val sympol= coinDetail?.symbol
                            txtRank.text = "$rank."
                            txtSympol.text = "($sympol)"

                            tagAdapter.tagsList = coinDetail?.tags ?: emptyList()
                            tagAdapter.notifyDataSetChanged()

                            membersAdapter.differ.submitList(coinDetail?.team)

                        }
                    }

                    is Resource.Error -> {
                        Toast.makeText(activity, resource.message ?: "Error", Toast.LENGTH_SHORT)
                            .show()
                    }

                    else -> {

                    }
                }

            }
        }

        binding.txtName.text = coinId
    }

    private fun setupMembersRecyclerView() {
        membersAdapter = TeamMembersAdapter()
        binding.rvTeamMembers.apply {
            adapter = membersAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun setupTagsRecyclerView() {
        tagAdapter = CoinTagsAdapter()
        val flexBox = FlexboxLayoutManager(activity).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.FLEX_START

        }
        binding.rvTags.apply {
            adapter = tagAdapter
            layoutManager = flexBox

        }
    }
}