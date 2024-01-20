package com.albireo3754.pickbangg.riot.dto

data class LeagueItemDTO(
    val freshBlood: Boolean,
    val wins: Int,
    val summonerName: String,
    val miniSeries: MiniSeriesDTO,
    val inactive: Boolean,
    val veteran: Boolean,
    val hotStreak: Boolean,
    val rank: String,
    val leaguePoints: Int,
    val losses: Int,
    val summonerId: String
) {
}
