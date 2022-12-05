package com.gergelytusko.JourneyCache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class JourneyCacheApplication

fun main(args: Array<String>) {
	runApplication<JourneyCacheApplication>(*args)
}
data class Journey(val id: Long,
				   val userId: Long,
				   val startLong: Double,
				   val startLat: Double,
				   val endLong: Double,
				   val endLat: Double,
				   val price: Double);

@RestController
class JourneyController {
	@GetMapping("/")
	fun getIndex() = "Hello world!"

	@GetMapping("/journey/{journey_id}")
	fun getJourney(@PathVariable journey_id: Long) = "Hello, $journey_id!"

	@GetMapping("/user/{user_id}/journeys")
	fun getUserJourneys(@PathVariable user_id: Long) = "Hello, $user_id!"
}