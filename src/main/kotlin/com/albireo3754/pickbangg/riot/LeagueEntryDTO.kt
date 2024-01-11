package com.albireo3754.pickbangg.riot

data class LeagueEntryDTOs(val leagueEntryDTOs: Set<LeagueEntryDTO>) {
}
data class LeagueEntryDTO(
    val leagueId: String,
    val summonerId: String, // Player's encrypted summonerId.
    val summonerName: String,
    val queueType: String,
    val tier: String,
    val rank: String, // The player's division within a tier.
    val leaguePoints: Int,
    val wins: Int, // Winning team on Summoners Rift.
    val losses: Int, // Losing team on Summoners Rift.
    val hotStreak: Boolean,
    val veteran: Boolean,
    val freshBlood: Boolean,
    val inactive: Boolean,
    val miniSeries: MiniSeriesDTO
) {
    data class MiniSeriesDTO(
        val losses: Int,
        val progress: String,
        val target: Int,
        val wins: Int
    )
}
