package com.gergelytusko.JourneyCache

import com.gergelytusko.JourneyCache.model.Journey
import kotlin.random.Random

fun populateWithRandomData(count: Int, cache: JourneyCache) {
    for (journeyId in 0..count){
        var userId = Random.nextLong(0,10000)
        var journey = Journey(journeyId.toLong(), userId, Random.nextDouble(),  Random.nextDouble(), Random.nextLong(), Random.nextDouble(), Random.nextDouble(), Random.nextLong(), Random.nextDouble())
        cache.add(journeyId.toLong(), journey)
    }
}