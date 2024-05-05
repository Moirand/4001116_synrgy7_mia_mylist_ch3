package com.example.mychampionlist.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mychampionlist.R
import com.example.mychampionlist.data.ChampionsList
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory.Companion.EMAIL
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory.Companion.TOKEN
import com.example.mychampionlist.databinding.FragmentHomeBinding
import com.example.mychampionlist.ui.adapter.ChampionListAdapter
import com.example.mychampionlist.ui.viewmodel.HomeViewModel
import com.example.mychampionlist.ui.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment(), MenuProvider {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val championListAdapter = ChampionListAdapter()
    private val viewModel by viewModels<HomeViewModel> { HomeViewModelFactory.getInstance(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedPreferences = SharedPreferencesFactory().createSharedPreferences(requireContext())
        return FragmentHomeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this, viewLifecycleOwner)

        with(binding.list) {
            adapter = championListAdapter
            viewModel.columnCount.observe(viewLifecycleOwner) { columnCount ->
                layoutManager =
                    if (columnCount == 1) LinearLayoutManager(context) else GridLayoutManager(context, columnCount)
            }
            refreshData()
            binding.swipeRefresh.setOnRefreshListener { refreshData() }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_item_fragment, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.layoutViewMenu -> {
                if (binding.list.layoutManager is LinearLayoutManager) viewModel.setColumnLayout(2) else viewModel.setColumnLayout(1)
                true
            }

            R.id.signoutMenu -> {
                removeSharedPreferencesData()
                navigateToLogin()
                true
            }

            R.id.deleteAccountMenu -> {
                viewModel.deleteUser(sharedPreferences.getString(EMAIL, null))
                removeSharedPreferencesData()
                navigateToLogin()
                true
            }

            else -> false
        }
    }

    private fun removeSharedPreferencesData() {
        sharedPreferences.edit().remove(TOKEN).apply()
        sharedPreferences.edit().remove(EMAIL).apply()
    }

    private fun navigateToLogin(){
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun refreshData() {
        championListAdapter.submitList(ChampionsList.champions)
        binding.swipeRefresh.isRefreshing = false
    }
}