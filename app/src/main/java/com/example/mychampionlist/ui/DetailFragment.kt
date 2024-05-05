package com.example.mychampionlist.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mychampionlist.ui.adapter.LoadImageUrl
import com.example.mychampionlist.data.Champions
import com.example.mychampionlist.data.Regions
import com.example.mychampionlist.data.Roles
import com.example.mychampionlist.databinding.FragmentDetailBinding
import com.example.mychampionlist.ui.viewmodel.DetailViewModel
import com.example.mychampionlist.ui.viewmodel.DetailViewModelFactory

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel> { DetailViewModelFactory() }

    companion object {
        const val CHAMPIONS_BUNDLE = "champion data"
        const val REGIONS_BUNDLE = "region data"
        const val ROLES_BUNDLE = "roles data"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDetailBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getArgs(
            championData = arguments?.getSerializable(CHAMPIONS_BUNDLE) as? Champions,
            regionData = arguments?.getSerializable(REGIONS_BUNDLE) as? Regions,
            roleData = arguments?.getSerializable(ROLES_BUNDLE) as List<Roles>
        )

        viewModel.champion.observe(viewLifecycleOwner) {
            it?.let { champion ->
                binding.imgChampIcon.LoadImageUrl(binding.root.context, champion.iconUrl)
                binding.tvChampName.text = champion.champName
                binding.tvChampAlias.text = champion.alias
                binding.tvChampQuote.text = resources.getString(champion.quote)
                binding.btnDeeplink.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(champion.siteUrl))
                    requireActivity().startActivity(intent)
                }
            }
        }

        viewModel.region.observe(viewLifecycleOwner) {
            it?.let { region ->
                binding.imgRegion.LoadImageUrl(binding.root.context, region.iconUrl)
                binding.tvRegion.text = region.regionName
            }
        }

        viewModel.role.observe(viewLifecycleOwner) {
            it?.let { roleData ->
                roleData.forEach {
//                val iconRoleView = CreateLinearLayoutCompat(requireContext(), 40, 40, 0, 0, 4, 0)
//                binding.linearlayRole.addView(iconRoleView)
                }
            }
        }
    }
}