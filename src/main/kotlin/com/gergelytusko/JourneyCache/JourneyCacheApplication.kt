package com.gergelytusko.JourneyCache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JourneyCacheApplication
var cache: JourneyCache = JourneyCache()

fun main(args: Array<String>) {
	runApplication<JourneyCacheApplication>(*args)
	populateWithRandomData(100, cache);
}