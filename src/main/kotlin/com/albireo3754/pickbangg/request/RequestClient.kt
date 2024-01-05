package com.albireo3754.pickbangg.request

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class RequestClient(val riotApiConfiguration: RiotApiConfiguration) {

    @Bean
    fun webClient() : WebClient {
        return WebClient.builder()
            .baseUrl("https://kr.api.riotgames.com/lol/league/v4/entries")
            .defaultHeader("X-Riot-Token", riotApiConfiguration.X_Riot_Token)
            .build()
    }
}