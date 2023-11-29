package com.example.cryptocurrencycleanarch.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrencycleanarch.core.Resource
import com.example.cryptocurrencycleanarch.databinding.FragmentCoinsListBinding
import com.example.cryptocurrencycleanarch.presentation.adapters.CoinAdapter
import com.example.cryptocurrencycleanarch.presentation.viewmodels.CoinViewModel
import kotlinx.coroutines.launch

class CoinsListFragment : Fragment() {

    private lateinit var viewModel: CoinViewModel
    lateinit var coinAdapter: CoinAdapter
    lateinit var binding: FragmentCoinsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinsListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        setupRecyclerView()

        coinAdapter.setOnItemClickListener {
            Toast.makeText(activity, it.name, Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
            viewModel.getCoins().collect() { resource ->
                when (resource) {

                    is Resource.Loading -> {
                        showProgressBar()
                    }

                    is Resource.Success -> {
                        hideProgressBar()
                        val coins = resource.data ?: emptyList()
                        coinAdapter.differ.submitList(coins)
                    }

                    is Resource.Error -> {
                        Toast.makeText(activity, resource.message, Toast.LENGTH_SHORT).show()
                    }

                }

            }
        }


    }

    private fun hideProgressBar() {
        binding.progressBar.isVisible = false
    }

    private fun showProgressBar() {
        binding.progressBar.isVisible = true
    }

    private fun setupRecyclerView() {
        coinAdapter = CoinAdapter()
        binding.rv.apply {
            adapter = coinAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}