package com.albireo3754.pickbangg

import com.albireo3754.pickbangg.riot.LeagueEntryDTO
import com.albireo3754.pickbangg.riot.RiotApiConfigurationProperties
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
@EnableConfigurationProperties(
	RiotApiConfigurationProperties::class
)
class PickbanggApplication {

}

fun main(args: Array<String>) {
	val applicationContext = runApplication<PickbanggApplication>(*args)
	applicationContext.getBean<WebClient>()
		.get()
		.uri("/{queue}/{tier}/{division}", "RANKED_SOLO_5x5", "DIAMOND", "I")
		.retrieve()
		.bodyToMono(ParameterizedTypeReference.forType<List<LeagueEntryDTO>>(List::class.java))
		.subscribe {
			println(it)
		}
}
