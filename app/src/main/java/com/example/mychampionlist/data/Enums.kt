package com.example.mychampionlist.data

import com.example.mychampionlist.R

enum class Champions(val champName: String, val alias: String, val quote: Int, val siteUrl: String, val splashUrl: String, val iconUrl: String) {
    CAITLYN("Caitlyn", "The Sheriff of Piltover", R.string.quote_caitlyn, "https://universe.leagueoflegends.com/en_US/champion/caitlyn/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/1/1b/Skin_Splash_Classic_Caitlyn.jpg/revision/latest?cb=20191210045644", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/51.png"),
    EZREAL("Ezreal", "The Prodigal Explorer", R.string.quote_ezreal, "https://universe.leagueoflegends.com/en_US/champion/ezreal/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/1/16/Skin_Splash_Classic_Ezreal.jpg/revision/latest?cb=20181011192407", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/81.png"),
    GRAVES("Graves", "The Outlaw", R.string.quote_graves, "https://universe.leagueoflegends.com/en_US/champion/graves/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/48/Skin_Splash_Classic_Graves.jpg/revision/latest?cb=20191210053255", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/104.png"),
    JANNA("Janna", "The Storm's Fury", R.string.quote_janna, "https://universe.leagueoflegends.com/en_US/champion/janna/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/88/Skin_Splash_Classic_Janna.jpg/revision/latest?cb=20191210061105", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/40.png"),
    KARMA("Karma", "The Enlightened One", R.string.quote_karma, "https://universe.leagueoflegends.com/en_US/champion/karma/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/57/Skin_Splash_Classic_Karma.jpg/revision/latest?cb=20191209212807", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/43.png"),
    KATARINA("Katarina", "The Sinister Blade", R.string.quote_katarina, "https://universe.leagueoflegends.com/en_US/champion/katarina/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/59/Skin_Splash_Classic_Katarina.jpg/revision/latest?cb=20191210053845", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/55.png"),
    LUX("Lux", "The Lady of Luminosity", R.string.quote_lux, "https://universe.leagueoflegends.com/en_US/champion/lux/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/1/1e/Skin_Splash_Classic_Lux.jpg/revision/latest?cb=20191210052803", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/99.png"),
    MALZAHAR("Malzahar", "The Prophet of The Void", R.string.quote_malzahar, "https://universe.leagueoflegends.com/en_US/champion/malzahar/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/1/1b/Skin_Splash_Classic_Malzahar.jpg/revision/latest?cb=20191210062431", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/90.png"),
    VIKTOR("Viktor", "The Machine Herald", R.string.quote_viktor, "https://universe.leagueoflegends.com/en_US/champion/viktor/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b2/Skin_Splash_Classic_Viktor.jpg/revision/latest?cb=20191212180255", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/112.png"),
    YASUO("Yasuo", "The Unforgiven", R.string.quote_yasuo, "https://universe.leagueoflegends.com/en_US/champion/yasuo/", "https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/1/12/Skin_Splash_Classic_Yasuo.jpg/revision/latest?cb=20191209231330", "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/157.png")
}

enum class Regions(val regionName: String, val splashUrl: String, val iconUrl: String) {
    BANDLE_CITY("Bandle City", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt57ea8bb74f8733f3/60ee0b95bc44fe5b48ba2a02/bandle-city_splash.jpg", "https://universe.leagueoflegends.com/images/bandle_city_crest_icon.png"),
    BILGEWATER("Bilgewater", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt8efd86a20a7fc6ca/60ee0bd126ed9249f5484b8c/bilgewater_splash.jpg", "https://universe.leagueoflegends.com/images/bilgewater_crest_icon.png"),
    DEMACIA("Demacia", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/bltd170f10ccce6ba7e/614cc12077d06a0c9835f862/demacia_splash.jpeg", "https://universe.leagueoflegends.com/images/demacia_crest_icon.png"),
    FRELJORD("Freljord", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/bltc15ba510f02e7e45/60ee0d9185b042284396138b/freljord_splash.jpg", "https://universe.leagueoflegends.com/images/freljord_crest_icon.png"),
    IONIA("Ionia", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/bltcea170f820e544c5/60ee0e19a471a34acb2c1f66/ionia-01.jpg", "https://universe.leagueoflegends.com/images/iona_crest_icon.png"),
    IXTAL("Ixtal", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt9a01601bbdff5c4a/60ee0e385fbfcb5e848229a5/ixtal_splash.jpg", "https://universe.leagueoflegends.com/images/ixtal_crest_icon.png"),
    NOXUS("Noxus", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt9d0c487b98ba6b42/60ee0ffb975ffd4ff25ec2f5/noxus_splash.jpg", "https://universe.leagueoflegends.com/images/noxus_crest_icon.png"),
    PILTOVER("Piltover", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt5c307209ccbe2470/60ee10d06610ed4d42bc222e/piltover_splash.jpg", "https://universe.leagueoflegends.com/images/piltover_crest_icon.png"),
    SHADOW_ISLES("Shadow Isles", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/bltd9cec6dc7ca0fc48/60ee11d22f7fa122fd574a11/shadow-isles_splash.jpg", "https://universe.leagueoflegends.com/images/shadow_isles_crest_icon.png"),
    SHURIMA("Shurima", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt5924e500520eabd9/60ee11fb94d70a1ef3123825/shurima_splash.jpg", "https://universe.leagueoflegends.com/images/shurima_crest_icon.png"),
    TARGON("Targon", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt1ab39bfee4a3057d/60ee0f894fba2021cde587f6/mount-targon_splash.jpg", "https://universe.leagueoflegends.com/images/mt_targon_crest_icon.png"),
    VOID("Void", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt4754fc6a91233824/60ee139d5397524ead38918f/void-an-unknowable-power.jpg", "https://universe.leagueoflegends.com/images/void_crest_icon.png"),
    ZAUN("Zaun", "https://images.contentstack.io/v3/assets/blt187521ff0727be24/blt3d038a51072c6d5a/614cc18164c8007a9bdec0e2/zaun_splash.jpeg", "https://universe.leagueoflegends.com/images/zaun_crest_icon.png")
}

enum class Roles(val role: String, val iconUrl: String) {
    MID("Mid Lane", "https://raw.githubusercontent.com/davidherasp/lol_images/master/role_lane_icons/MIDDLE.png"),
    SOLO("Solo Lane", "https://raw.githubusercontent.com/davidherasp/lol_images/master/role_lane_icons/TOP.png"),
    DUO("Duo Lane", "https://raw.githubusercontent.com/esports-bits/lol_images/master/role_lane_icons/ADC.png"),
    SUPPORT("Support", "https://raw.githubusercontent.com/esports-bits/lol_images/master/role_lane_icons/SUPPORT.png"),
    JUNGLE("Jungle", "https://raw.githubusercontent.com/davidherasp/lol_images/master/role_lane_icons/JUNGLE.png")
}