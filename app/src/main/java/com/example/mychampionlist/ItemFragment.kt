package com.example.mychampionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mychampionlist.data.ChampionsList
import com.example.mychampionlist.databinding.FragmentItemListBinding

class ItemFragment : Fragment(), MenuProvider {

    private var columnCount = 1
    private lateinit var binding: FragmentItemListBinding
    private val championListAdapter = ChampionListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentItemListBinding.inflate(inflater, container, false).also{
            binding = it
        }.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this, viewLifecycleOwner)

        with(binding.list) {
            adapter = championListAdapter
            refreshData()
            binding.swipeRefresh.setOnRefreshListener { refreshData() }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_item_fragment, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.layoutview -> {
                if (columnCount == 1) {
                    columnCount = 2
                    binding.list.layoutManager = GridLayoutManager(context, columnCount)
                } else {
                    columnCount = 1
                    binding.list.layoutManager = LinearLayoutManager(context)
                }
                true
            }
            else -> false
        }
    }
    private fun refreshData() {
        // Submit a new list of movies to the movie adapter
        championListAdapter.submitList(ChampionsList.champions)
        // Disable the swipe-to-refresh indicator
        binding.swipeRefresh.isRefreshing = false
    }
}