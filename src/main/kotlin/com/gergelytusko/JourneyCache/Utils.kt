package com.gergelytusko.JourneyCache

import com.gergelytusko.JourneyCache.model.Journey
import kotlin.random.Random

fun populateWithRandomData(count: Int, cache: JourneyCache) {
    for (journeyId in 0..count){
        var userId = Random.nextLong(0,100)
        var journey = Journey(journeyId.toLong(), userId, Random.nextDouble(),  Random.nextDouble(), Random.nextLong(), Random.nextDouble(), Random.nextDouble(), Random.nextLong(), Random.nextDouble())
        cache.add(journey)
    }
}

fun createPopulatedCache(numberOfJourneys: Int, numberOfUsers: Int): JourneyCache {
    var cache: JourneyCache = JourneyCache()
    for (journeyId in 0..numberOfJourneys){
        var userId = journeyId % numberOfUsers
        var journey = Journey(journeyId.toLong(), userId.toLong(), Random.nextDouble(),  Random.nextDouble(), Random.nextLong(), Random.nextDouble(), Random.nextDouble(), Random.nextLong(), Random.nextDouble())
        cache.add(journey)
    }
    return cache
}