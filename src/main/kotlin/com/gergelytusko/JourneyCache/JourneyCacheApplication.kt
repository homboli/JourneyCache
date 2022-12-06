package com.gergelytusko.JourneyCache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@SpringBootApplication
class JourneyCacheApplication
var cache: Cache = Cache()
fun main(args: Array<String>) {
	runApplication<JourneyCacheApplication>(*args)
	cache.populateWithRandomData(100)
}
data class Journey(val id: Long,
				   val userId: Long,
				   val startLong: Double,
				   val startLat: Double,
				   val startTime: Long,
				   val endLong: Double,
				   val endLat: Double,
				   val endTime: Long,
				   val price: Double);

@RestController
class JourneyController {
	@GetMapping("/")
	fun getIndex() = "Hello world!"

	@GetMapping("/journey/{journey_id}")
	fun getJourney(@PathVariable journey_id: Long) = cache.get(journey_id)

	@GetMapping("/user/{user_id}/journeys")
	fun getUserJourneys(@PathVariable user_id: Long) = cache.getUserJourneys(user_id)
}

class Cache {
	var journeys: HashMap<Long, Journey> = hashMapOf()
	var users: HashMap<Long, ArrayList<Long>> = hashMapOf()
	fun populateWithRandomData(count: Int) {
		for (journeyId in 0..count){
			var userId = Random.nextLong(0,30)
			var journey = Journey(journeyId.toLong(), userId, Random.nextDouble(),  Random.nextDouble(), Random.nextLong(), Random.nextDouble(), Random.nextDouble(), Random.nextLong(), Random.nextDouble())
			journeys.put(journeyId.toLong(), journey)
			if(users.containsKey(userId)){
				users[userId]?.add(journeyId.toLong())
			} else {
				users.put(userId, arrayListOf(journeyId.toLong()))
			}
		}
	}

	fun get(id: Long): Journey? {
		return journeys.get(id)
	}

	fun getUserJourneys(userId: Long): ArrayList<Journey> {
		var journeyList: ArrayList<Journey> = ArrayList()
		var userJourneyIds: ArrayList<Long> = users.get(userId)!!
		if (userJourneyIds != null) {
			for (element in userJourneyIds) {
				journeyList.add(journeys.get(element)!!)
			}
		}
		return journeyList
	}
}