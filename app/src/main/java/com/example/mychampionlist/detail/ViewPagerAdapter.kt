package com.example.mychampionlist.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mychampionlist.data.Champion
import com.example.mychampionlist.detail.tablayout.DetailFragment
import com.example.mychampionlist.detail.tablayout.StoryFragment
import java.io.Serializable

class ViewPagerAdapter(
    fragment: Fragment,
    private val fragments: List<Fragment>,
    private val champion: Champion

) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].also {
            it.arguments = Bundle().apply {
                putSerializable(DetailFragment.CHAMPIONS_BUNDLE, champion.name)
                putSerializable(DetailFragment.REGIONS_BUNDLE, champion.region)
                putSerializable(DetailFragment.ROLES_BUNDLE, champion.role as Serializable)
                putInt(StoryFragment.CHAMPION_STORY, champion.story)
            }
        }
    }
}