package com.example.mychampionlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mychampionlist.ui.adapter.LoadImageUrl
import com.example.mychampionlist.R
import com.example.mychampionlist.databinding.FragmentListItemBinding
import com.example.mychampionlist.ui.adapter.ViewPagerAdapter
import com.example.mychampionlist.ui.viewmodel.ListItemViewModel
import com.example.mychampionlist.ui.viewmodel.ListItemViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class ListItemFragment : Fragment() {
    private val args: ListItemFragmentArgs by navArgs()
    private lateinit var binding: FragmentListItemBinding
    private val viewModel by viewModels<ListItemViewModel> {
        ListItemViewModelFactory.getInstance(args)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentListItemBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getArgs()
        viewModel.championData.observe(viewLifecycleOwner) { champion ->
            binding.imgSplash.LoadImageUrl(binding.root.context, champion.name.splashUrl)

            binding.viewpager.adapter =
                ViewPagerAdapter(this, listOf(DetailFragment(), BioFragment()), champion)
            TabLayoutMediator(binding.tab, binding.viewpager) { tab, position ->
                tab.text = when (position) {
                    0 -> resources.getString(R.string.detail_tab_name)
                    else -> resources.getString(R.string.bio_tab_name)
                }
            }.attach()
        }
    }
}