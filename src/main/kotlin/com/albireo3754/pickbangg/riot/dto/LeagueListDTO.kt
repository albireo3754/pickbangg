package com.albireo3754.pickbangg.riot.dto

data class LeagueListDTO(
    val leagueId: String,
    val entries: List<LeagueItemDTO>,
    val tier: String,
    val queue: String,
    val name: String
) {

}