package com.example.mychampionlist.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mychampionlist.LoadImageUrl
import com.example.mychampionlist.R
import com.example.mychampionlist.databinding.FragmentDetailsBinding
import com.example.mychampionlist.detail.tablayout.DetailFragment
import com.example.mychampionlist.detail.tablayout.StoryFragment
import com.google.android.material.tabs.TabLayoutMediator

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDetailsBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val champion = args.dataChampion

        binding.imgSplash.LoadImageUrl(context, champion.name.splashUrl)

        binding.viewpager.adapter =
            ViewPagerAdapter(this, listOf(DetailFragment(), StoryFragment()), champion)
        TabLayoutMediator(binding.tab, binding.viewpager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.detail_tab_name)
                else -> resources.getString(R.string.bio_tab_name)
            }
        }.attach()
    }
}