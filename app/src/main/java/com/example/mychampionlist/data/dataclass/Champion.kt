package com.example.mychampionlist.data.dataclass

import com.example.mychampionlist.data.Champions
import com.example.mychampionlist.data.Regions
import com.example.mychampionlist.data.Roles
import java.io.Serializable

data class Champion (
    val name: Champions,
    val region: Regions,
    val role: List<Roles>,
    val story: Int,
    ) : Serializable