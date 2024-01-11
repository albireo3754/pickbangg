package com.albireo3754.pickbangg.request

import com.albireo3754.pickbangg.request.summoner_v4.SummonerDTO
import com.albireo3754.pickbangg.riot.LeagueEntryDTO
import com.albireo3754.pickbangg.riot.Tier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class RiotClient(val riotWebClient: WebClient) {
    fun getLeagueEntryDTOs(queue: String, tier: Tier, division: String): Mono<List<LeagueEntryDTO>> {
        return riotWebClient.get()
            .uri("/{queue}/{tier}/{division}", queue, tier.toString(), division)
            .retrieve()
            // get List Of LeagueEntryDTO
            .bodyToMono(ParameterizedTypeReference.forType(List::class.java))
    }

    fun getSummonerByName(summonerName: String): Mono<SummonerDTO?> {
        return riotWebClient.get()
            .uri("/summoners/by-name/{summonerName}", summonerName)
            .retrieve()
            .bodyToMono(SummonerDTO::class.java)
    }
}