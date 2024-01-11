package com.albireo3754.pickbangg.request

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(val riotApiConfiguration: RiotApiConfiguration) {

    @Bean
    fun riotWebClient() : WebClient {
        return WebClient.builder()
            .baseUrl("https://kr.api.riotgames.com/lol/league/v4/entries")
            .defaultHeader("X-Riot-Token", riotApiConfiguration.X_Riot_Token)
            .build()
    }
}