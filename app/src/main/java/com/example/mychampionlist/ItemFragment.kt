package com.example.mychampionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mychampionlist.data.ChampionsList
import com.example.mychampionlist.databinding.FragmentItemListBinding

class ItemFragment : Fragment() {

    private var columnCount = 1
    private lateinit var binding: FragmentItemListBinding
    private val championListAdapter = ChampionListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentItemListBinding.inflate(inflater, container, false).also{
            binding = it
        }

        with(view.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = championListAdapter
            refreshData()
            binding.swipeRefresh.setOnRefreshListener { refreshData() }
        }
        return view.root
    }

    private fun refreshData() {
        // Submit a new list of movies to the movie adapter
        championListAdapter.submitList(ChampionsList.champions)
        // Disable the swipe-to-refresh indicator
        binding.swipeRefresh.isRefreshing = false
    }
}