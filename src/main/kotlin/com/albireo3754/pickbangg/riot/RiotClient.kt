package com.albireo3754.pickbangg.request

import com.albireo3754.pickbangg.request.summoner_v4.SummonerDTO
import com.albireo3754.pickbangg.riot.dto.Division
import com.albireo3754.pickbangg.riot.dto.LeagueEntryDTO
import com.albireo3754.pickbangg.riot.dto.Tier
import com.albireo3754.pickbangg.riot.dto.LeagueListDTO
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

// https://developer.riotgames.com/apis

@Component
class RiotClient(val riotWebClient: WebClient) {
    fun getChallengerLeagues(queue: String = "RANKED_SOLO_5x5"): Mono<LeagueListDTO> {
        return riotWebClient.get()
            .uri("/lol/league/v4/challengerleagues/by-queue/{queue}", queue)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getEntriesBySummonerId(encryptedSummonerId: String): Mono<List<LeagueEntryDTO>> {
        return riotWebClient.get()
            .uri("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}", encryptedSummonerId)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getEntries(queue: String = "RANKED_SOLO_5x5", tier: Tier, division: Division, page: Int = 1): Mono<List<LeagueEntryDTO>> {
        return riotWebClient.get()
            .uri("/lol/league/v4/entries/{queue}/{tier}/{division}?page={page}", queue, tier, division, page)
            .attribute("page", page)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getGrandmasterLeagues(queue: String = "RANKED_SOLO_5x5"): Mono<LeagueListDTO> {
        return riotWebClient.get()
            .uri("/lol/league/v4/grandmasterleagues/by-queue/{queue}", queue)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getMatchIdsByUserPUUID(userPUUID: String, startTime: Long, endTime: Long, queue: Int, type: String = "ranked", start: Int, count: Int): Mono<List<String>> {
        return riotWebClient.get()
            .uri("/lol/match/v5/matches/by-puuid/{puuid}/ids",)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getLeaguesWithLeagueId(leagueId: String): Mono<LeagueListDTO> {
        return riotWebClient.get()
            .uri("/lol/league/v4/leagues/{leagueId}", leagueId)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getMasterLeagues(queue: String = "RANKED_SOLO_5x5"): Mono<LeagueListDTO> {
        return riotWebClient.get()
            .uri("/lol/league/v4/masterleagues/by-queue/{queue}", queue)
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getSummonerByName(summonerName: String): Mono<SummonerDTO?> {
        return riotWebClient.get()
            .uri("/lol/summoner/v4/summoners/by-name/{summonerName}", summonerName)
            .retrieve()
            .bodyToMono(SummonerDTO::class.java)
    }

    fun getSummonerByEncryptedSummonerId(encryptedSummonerId: String): Mono<SummonerDTO?> {
        return riotWebClient.get()
            .uri("/lol/summoner/v4/summoners/{encryptedSummonerId}?", encryptedSummonerId)
            .retrieve()
            .bodyToMono(SummonerDTO::class.java)
    }

    fun getSummonerByPuuid(encryptedPUUID: String): Mono<SummonerDTO?> {
        return riotWebClient.get()
            .uri("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}", encryptedPUUID)
            .retrieve()
            .bodyToMono(SummonerDTO::class.java)
    }
}

