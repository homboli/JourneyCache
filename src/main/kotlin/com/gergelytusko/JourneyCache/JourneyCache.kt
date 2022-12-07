package com.gergelytusko.JourneyCache

import com.gergelytusko.JourneyCache.exception.NotFoundException
import com.gergelytusko.JourneyCache.model.Journey

class JourneyCache {
    var journeys: HashMap<Long, HashMap<Long, Journey>> = hashMapOf()

    fun getJourney(userId: Long, journeyId: Long): Journey {
        val foundUser = journeys[userId]
        if(foundUser == null) {
            throw NotFoundException("User (${userId.toString()}) not found");
        } else {
            val foundJourney = foundUser[journeyId]
            if (foundJourney == null) {
                throw NotFoundException("Journey (${journeyId.toString()}) not found");
            } else {
                return foundJourney;
            }
        }
    }

    fun add(journey: Journey){
        if(!journeys.containsKey(journey.userId)){
            journeys.put(journey.userId, HashMap<Long, Journey>())
        }
        journeys[journey.userId]!![journey.id] = journey
    }

    fun getUserJourneys(userId: Long): ArrayList<Journey> {
        val foundUser = journeys[userId]
        if(foundUser == null) {
            throw NotFoundException("User (${userId.toString()}) not found");
        } else {
            return ArrayList<Journey>(foundUser.values)
        }
    }
}