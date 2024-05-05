package com.example.mychampionlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mychampionlist.databinding.FragmentBioBinding
import com.example.mychampionlist.ui.viewmodel.BioViewModel
import com.example.mychampionlist.ui.viewmodel.BioViewModelFactory

class BioFragment : Fragment() {
    private lateinit var binding: FragmentBioBinding
    private val viewModel by viewModels<BioViewModel> { BioViewModelFactory() }

    companion object {
        const val CHAMPION_BIO = "bio champion"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBioBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getArgs(arguments?.getInt(CHAMPION_BIO))

        viewModel.bio.observe(viewLifecycleOwner) {
            it?.let { bio ->
                binding.tvStory.text = resources.getString(bio)
            }
        }
    }
}