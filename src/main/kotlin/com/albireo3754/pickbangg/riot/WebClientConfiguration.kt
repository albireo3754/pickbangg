package com.albireo3754.pickbangg.request

import com.albireo3754.pickbangg.riot.RiotApiConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration(val riotApiConfiguration: RiotApiConfigurationProperties) {

    @Bean
    fun riotWebClient() : WebClient {
        return WebClient.builder()
            .baseUrl("https://kr.api.riotgames.com")
            .defaultHeader("X-Riot-Token", riotApiConfiguration.X_Riot_Token)
            .build()
    }
}