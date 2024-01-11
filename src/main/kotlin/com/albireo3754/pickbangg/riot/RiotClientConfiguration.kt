package com.albireo3754.pickbangg.riot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class RiotClientConfiguration(val riotApiConfiguration: RiotApiConfigurationProperties) {

    @Bean
    fun riotClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://kr.api.riotgames.com")
            .defaultHeader("X-Riot-Token", riotApiConfiguration.X_Riot_Token)
            .build()
    }
}

@Component
class RiotClient(private val riotClient: WebClient) {
    enum class Tier {
        DIAMOND, EMERALRD, PLATINUM, GOLD, SILVER, BRONZE, IRON
    }
    fun getLeagueEntryDTOs(queue: String, tier: Tier, division: String): List<LeagueEntryDTO> {
        return riotClient.get()
            .uri("/lol/league/v4/entries/{queue}/{tier}/{division}", "RANKED_SOLO_5x5", tier.toString(), "I")
            .retrieve()
            .bodyToMono(ParameterizedTypeReference.forType<List<LeagueEntryDTO>>(List::class.java))
            .block() ?: emptyList()
    }
}