package com.example.mychampionlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mychampionlist.data.Champion
import com.example.mychampionlist.databinding.FragmentItemBinding
import com.example.mychampionlist.utils.ChampionDiffUtil
import com.google.android.material.imageview.ShapeableImageView

class ChampionListAdapter :
    ListAdapter<Champion, ChampionListAdapter.ViewHolder>(ChampionDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
    override fun getItemCount(): Int = currentList.size
    inner class ViewHolder(private val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Champion) {
            data.name.let { champion ->
                binding.tvChamp.text = champion.champName
                binding.tvAlias.text = champion.alias
                binding.iconChamp.LoadImageUrl(binding.root.context, champion.iconUrl)
            }

            data.region.let { region ->
                binding.tvRegion.text = region.regionName
                binding.iconRegion.LoadImageUrl(binding.root.context, region.iconUrl)
            }

            data.role.forEach { role ->
                val iconRoleView =
                    CreateShapeableImageView(binding.root.context, 30, 30, 0, 0, 4, 0)
                binding.iconRole.addView(iconRoleView)
                iconRoleView.LoadImageUrl(binding.root.context, role.iconUrl)
            }

            binding.champCardView.setOnClickListener {
                binding.root.findNavController().navigate(
                    ItemFragmentDirections.actionItemFragmentToDetailsFragment(
                        Champion(
                            data.name,
                            data.region,
                            data.role,
                            data.story
                        )
                    )
                )
            }

        }
    }
}

fun dpTOpx(context: Context, dp: Int): Int = (dp * context.resources.displayMetrics.density).toInt()

fun ShapeableImageView.LoadImageUrl(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun CreateShapeableImageView(
    context: Context,
    width: Int,
    height: Int,
    paddingLeft: Int,
    paddingTop: Int,
    paddingRight: Int,
    paddingBottom: Int,
): ShapeableImageView {
    return ShapeableImageView(context).apply {
        minimumWidth = dpTOpx(context, width)
        minimumHeight = dpTOpx(context, height)
        setContentPadding(
            dpTOpx(context, paddingLeft),
            dpTOpx(context, paddingTop),
            dpTOpx(context, paddingRight),
            dpTOpx(context, paddingBottom)
        )
    }
}

