package com.example.mychampionlist.detail.tablayout

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.example.mychampionlist.LoadImageUrl
import com.example.mychampionlist.data.Champions
import com.example.mychampionlist.data.Regions
import com.example.mychampionlist.data.Roles
import com.example.mychampionlist.databinding.FragmentDetailBinding
import com.example.mychampionlist.dpTOpx

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    companion object {
        const val CHAMPIONS_BUNDLE = "CHAMPIONS DATA"
        const val REGIONS_BUNDLE = "REGIONS DATA"
        const val ROLES_BUNDLE = "ROLES DATA"
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

        val champion = arguments?.getSerializable(CHAMPIONS_BUNDLE) as? Champions
        val region = arguments?.getSerializable(REGIONS_BUNDLE) as? Regions
        val role = arguments?.getSerializable(ROLES_BUNDLE) as List<Roles>

        champion?.let {
            binding.imgChampIcon.LoadImageUrl(context, it.iconUrl)
            binding.tvChampAlias.text = it.alias
        }

        role.let {
            it.forEach { role ->
                val iconRoleView = CreateLinearLayoutCompat(requireContext(), 30, 30, 0, 0, 4, 0)
                binding.linearlayRole.addView(iconRoleView)
            }
        }
    }
}

fun CreateLinearLayoutCompat(
    context: Context,
    width: Int,
    height: Int,
    paddingLeft: Int,
    paddingTop: Int,
    paddingRight: Int,
    paddingBottom: Int,
): LinearLayoutCompat {
    return LinearLayoutCompat(context).apply {
        minimumWidth = dpTOpx(context, width)
        minimumHeight = dpTOpx(context, height)
    }
}