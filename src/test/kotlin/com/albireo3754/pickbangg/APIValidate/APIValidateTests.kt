package com.albireo3754.pickbangg.APIValidate

import com.albireo3754.pickbangg.request.RiotClient
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.servlet.client.MockMvcWebTestClient
import org.springframework.web.client.RestClient
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@SpringBootTest
class APIValidateTests @Autowired constructor(val riotClient: RiotClient) {
//    @Test
//    fun test_restRequestToLeagueV4Entries() {
//        webClient.get()
//            .uri("/lol/league/v4/entries/{queue}/{tier}/{division}", "RANKED_SOLO_5x5", "DIAMOND", "I")
//            .retrieve()
//            .bodyToMono(String::class.java)
//            .onErrorResume { Mono.just("${it}") }
//            .subscribe { println(it) }
//
//    }
//
    @Test
    fun test_summoner_v4_byName() {
        riotClient.getSummonerByName("못하니깐골드다")
            .subscribe { println(it) }
    }
}