package com.gergelytusko.JourneyCache.service

import com.gergelytusko.JourneyCache.JourneyCache
import com.gergelytusko.JourneyCache.model.Journey
import com.gergelytusko.JourneyCache.populateWithRandomData
import org.springframework.stereotype.Service

@Service
class JourneyService {
    val cache: JourneyCache = JourneyCache()

    init {
        populateWithRandomData(1000000, cache)
    }
    fun getJourneysByUserId(userId: Long): ArrayList<Journey> {
        return cache.getUserJourneys(userId)
    }

    fun getJourneyByJourneyId(journeyId: Long): Journey {
        return cache.getJourney(journeyId)
    }

}