package com.gergelytusko.JourneyCache.service

import com.gergelytusko.JourneyCache.JourneyCache
import com.gergelytusko.JourneyCache.model.Journey
import com.gergelytusko.JourneyCache.populateWithRandomData

class JourneyService {
    val cache: JourneyCache = JourneyCache()

    init {
        populateWithRandomData(1000000, cache)
    }
    fun getJourneysByUserId(userId: Long): ArrayList<Journey> {
        return cache.getUserJourneys(userId)
    }

    fun getJourneyByJourneyId(journeyId: Long): Journey {
        var resultJourney: Journey? = cache.getJourney(journeyId)
        if(resultJourney != null)
            return resultJourney
        else
            throw Exception("Journey not found")
    }

}