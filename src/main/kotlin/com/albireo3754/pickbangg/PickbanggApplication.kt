package com.albireo3754.pickbangg

import com.albireo3754.pickbangg.request.RiotClient
import com.albireo3754.pickbangg.riot.dto.Division
import com.albireo3754.pickbangg.riot.RiotApiConfigurationProperties
import com.albireo3754.pickbangg.riot.dto.Tier
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	RiotApiConfigurationProperties::class
)
class PickbanggApplication {

}

fun main(args: Array<String>) {
	val applicationContext = runApplication<PickbanggApplication>(*args)
//	applicationContext.getBean<WebClient>()
//		.get()
//		.uri("/{queue}/{tier}/{division}", "RANKED_SOLO_5x5", "DIAMOND", "I")
//		.retrieve()
//		.bodyToMono(ParameterizedTypeReference.forType<List<LeagueEntryDTO>>(List::class.java))
//		.subscribe {
//			println(it)
//		}
	val summonerDTO = applicationContext.getBean<RiotClient>()
		.getSummonerByName("못하니깐골드다")
		.block()
	val summonerDTO2 = applicationContext.getBean<RiotClient>()
		.getSummonerByPuuid("CKdC8n3O16oZOcmz0jFub8-TVCAdPN-3xbZ3-3uVurcUF-WIBFqxoFSK4n6Gt9shXJkI30oQof2_tQ")
		.block()
	val matchEntrys = applicationContext.getBean<RiotClient>()
		.getEntries(tier = Tier.SILVER, division = Division.I, page = 2).block()
}
