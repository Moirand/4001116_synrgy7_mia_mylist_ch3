package com.example.mychampionlist.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.mychampionlist.data.dataclass.Champion

class ChampionDiffUtil: DiffUtil.ItemCallback<Champion>() {
    override fun areItemsTheSame(oldItem: Champion, newItem: Champion): Boolean {
        return oldItem.name == newItem.name
    }
    override fun areContentsTheSame(oldItem: Champion, newItem: Champion): Boolean {
        return oldItem.name == newItem.name
    }
}