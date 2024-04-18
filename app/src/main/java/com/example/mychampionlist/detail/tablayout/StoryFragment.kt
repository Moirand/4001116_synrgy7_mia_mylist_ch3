package com.example.mychampionlist.detail.tablayout

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.mychampionlist.databinding.FragmentStoryBinding

class StoryFragment : Fragment() {
    private lateinit var binding: FragmentStoryBinding

    companion object {
        const val CHAMPION_STORY = "BIO CHAMPION"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentStoryBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bio = arguments?.getInt(CHAMPION_STORY)

        bio?.let {
            binding.tvStory.text = resources.getString(it)
        }
    }
}