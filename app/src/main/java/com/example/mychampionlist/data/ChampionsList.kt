package com.example.mychampionlist.data

import com.example.mychampionlist.R
import com.example.mychampionlist.data.dataclass.Champion

object ChampionsList {
    val champions : List<Champion> = listOf(
        Champion(
            Champions.CAITLYN,
            Regions.PILTOVER,
            listOf(Roles.DUO),
            R.string.bio_caitlyn
        ),
        Champion(
            Champions.EZREAL,
            Regions.PILTOVER,
            listOf(Roles.MID, Roles.DUO),
            R.string.bio_ezreal
        ),
        Champion(
            Champions.GRAVES,
            Regions.BILGEWATER,
            listOf(Roles.SOLO, Roles.JUNGLE),
            R.string.bio_graves
        ),
        Champion(
            Champions.JANNA,
            Regions.ZAUN,
            listOf(Roles.SUPPORT),
            R.string.bio_janna
        ),
        Champion(
            Champions.KARMA,
            Regions.IONIA,
            listOf(Roles.MID, Roles.SUPPORT),
            R.string.bio_karma
        ),
        Champion(
            Champions.KATARINA,
            Regions.NOXUS,
            listOf(Roles.MID),
            R.string.bio_katarina
        ),
        Champion(
            Champions.LUX,
            Regions.DEMACIA,
            listOf(Roles.MID, Roles.SUPPORT),
            R.string.bio_lux
        ),
        Champion(
            Champions.MALZAHAR,
            Regions.VOID,
            listOf(Roles.MID, Roles.JUNGLE),
            R.string.bio_malzahar
        ),
        Champion(
            Champions.VIKTOR,
            Regions.ZAUN,
            listOf(Roles.MID),
            R.string.bio_viktor
        ),
        Champion(
            Champions.YASUO,
            Regions.IONIA,
            listOf(Roles.MID, Roles.SOLO),
            R.string.bio_yasuo
        ),
    )
}