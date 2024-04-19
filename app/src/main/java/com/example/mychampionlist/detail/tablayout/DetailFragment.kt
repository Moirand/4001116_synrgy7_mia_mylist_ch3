package com.example.mychampionlist.detail.tablayout

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.mychampionlist.LoadImageUrl
import com.example.mychampionlist.R
import com.example.mychampionlist.data.Champions
import com.example.mychampionlist.data.Regions
import com.example.mychampionlist.data.Roles
import com.example.mychampionlist.databinding.FragmentDetailBinding

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

        val championData = arguments?.getSerializable(CHAMPIONS_BUNDLE) as? Champions
        val regionData = arguments?.getSerializable(REGIONS_BUNDLE) as? Regions
        val roleData = arguments?.getSerializable(ROLES_BUNDLE) as List<Roles>

        championData?.let { champion ->
            binding.imgChampIcon.LoadImageUrl(binding.root.context, champion.iconUrl)
            binding.tvChampName.text = champion.champName
            binding.tvChampAlias.text = champion.alias
            binding.tvChampQuote.text = resources.getString(R.string.quote, champion.quote)
            binding.btnDeeplink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(champion.siteUrl))
                requireActivity().startActivity(intent)
            }
        }

        roleData.let {
            it.forEach {
//                val iconRoleView = CreateLinearLayoutCompat(requireContext(), 40, 40, 0, 0, 4, 0)
//                binding.linearlayRole.addView(iconRoleView)
            }
        }

        regionData?.let {
            binding.imgRegion.LoadImageUrl(binding.root.context, it.iconUrl)
            binding.tvRegion.text = it.regionName
        }
    }
}

//fun CreateLinearLayoutCompat(
//    context: Context,
//    width: Int,
//    height: Int,
//    marginHorizontal: Int
//): LinearLayoutCompat {
//    return LinearLayoutCompat(context).apply {
//        minimumWidth = dpTOpx(context, width)
//        minimumHeight = dpTOpx(context, height)
//        layoutParams.apply {
//            margin
//        }
//    }
//}

//<androidx.appcompat.widget.LinearLayoutCompat
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginHorizontal="4dp"
//android:gravity="center"
//android:orientation="vertical">
//
//<com.google.android.material.imageview.ShapeableImageView
//android:layout_width="40dp"
//android:layout_height="40dp"
//android:layout_marginBottom="4dp"
//android:src="@mipmap/ic_launcher" />
//
//<com.google.android.material.textview.MaterialTextView
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Mid Lane" />
//</androidx.appcompat.widget.LinearLayoutCompat>