package com.albireo3754.pickbangg.request.summoner_v4

// https://developer.riotgames.com/apis#summoner-v4/GET_getBySummonerName
// accountId	string	Encrypted account ID. Max length 56 characters.
// profileIconId	int	ID of the summoner icon associated with the summoner.
// revisionDate	long	Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: summoner name change, summoner level change, or profile icon change.
// name	string	Summoner name.
// id	string	Encrypted summoner ID. Max length 63 characters.
// puuid	string	Encrypted PUUID. Exact length of 78 characters.
// summonerLevel	long	Summoner level associated with the summoner.
data class SummonerDTO(
    val accountId: String,
    val profileIconId: Int,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: Long
) {
}