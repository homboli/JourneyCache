package com.gergelytusko.JourneyCache

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class JourneyCacheApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun cacheGetJourney(){
		val cachePopulationStartTimeStamp = System.currentTimeMillis()
		println("Cache population started at ${Date(cachePopulationStartTimeStamp)}")
		val cache: JourneyCache = createPopulatedCache(2000000, 999)
		val cachePopulationFinishTimeStamp = System.currentTimeMillis()
		println("Cache population finished at ${Date(cachePopulationFinishTimeStamp)}")
		val getStartTimeStamp = System.currentTimeMillis()
		println("Get method invoked at ${Date(getStartTimeStamp)}")
		var journey = cache.getJourney(1, 1000)
		val getFinishTimeStamp = System.currentTimeMillis()
		println("Get method returned at ${Date(getFinishTimeStamp)}")
		println("Execution time of the getJourney query: ${getFinishTimeStamp-getStartTimeStamp} ms")
		assert(journey.userId.equals(1.toLong()))
		assert(journey.id.equals(1000.toLong()))
	}

	@Test
	fun cacheGetUserJourneys(){
		val cachePopulationStartTimeStamp = System.currentTimeMillis()
		println("Cache population started at ${Date(cachePopulationStartTimeStamp)}")
		val cache: JourneyCache = createPopulatedCache(2000000, 99999)
		val cachePopulationFinishTimeStamp = System.currentTimeMillis()
		println("Cache population finished at ${Date(cachePopulationFinishTimeStamp)}")
		val getStartTimeStamp = System.currentTimeMillis()
		println("Get method invoked at ${Date(getStartTimeStamp)}")
		var journeys = cache.getUserJourneys(10900)
		val getFinishTimeStamp = System.currentTimeMillis()
		println("Get method returned at ${Date(getFinishTimeStamp)}")
		println("Execution time of the getUserJourneys query: ${getFinishTimeStamp-getStartTimeStamp} ms")
		assert(journeys[0].userId.equals(10900.toLong()))
	}

}
