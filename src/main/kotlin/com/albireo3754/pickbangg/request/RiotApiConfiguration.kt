package com.albireo3754.pickbangg.request

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "riot.api")
class RiotApiConfiguration(val X_Riot_Token: String) {
}