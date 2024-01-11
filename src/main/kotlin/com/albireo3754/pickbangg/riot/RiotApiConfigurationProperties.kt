package com.albireo3754.pickbangg.riot

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "riot.api")
class RiotApiConfigurationProperties(val X_Riot_Token: String) {
}