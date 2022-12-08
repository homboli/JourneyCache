package com.gergelytusko.JourneyCache.service

import com.gergelytusko.JourneyCache.JourneyCache
import com.gergelytusko.JourneyCache.model.Journey
import org.springframework.stereotype.Service

@Service
class JourneyService {
    //val cache: JourneyCache = createPopulatedCache(1000000, 9999)
    val cache: JourneyCache = JourneyCache()
    fun getJourneysByUserId(userId: Long): ArrayList<Journey> {
        return cache.getUserJourneys(userId)
    }

    fun getJourney(userId: Long, journeyId: Long): Journey {
        return cache.getJourney(userId, journeyId)
    }

}