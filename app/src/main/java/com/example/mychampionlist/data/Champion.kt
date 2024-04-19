package com.example.mychampionlist.data

import java.io.Serializable
data class Champion (
    val name: Champions,
    val region: Regions,
    val role: List<Roles>,
    val story: Int,
    ) : Serializable