package com.gergelytusko.JourneyCache

import com.gergelytusko.JourneyCache.exception.NotFoundException
import com.gergelytusko.JourneyCache.model.Journey

class JourneyCache {
    var journeys: HashMap<Long, Journey> = hashMapOf()
    var users: HashMap<Long, ArrayList<Long>> = hashMapOf()

    fun getJourney(id: Long): Journey {
        var foundJourney = journeys.get(id)
        if(foundJourney == null) {
            throw NotFoundException("Journey (${id.toString()}) not found");
        } else {
            return foundJourney;
        }
    }

    fun add(journeyId: Long, journey: Journey){
        if(users.containsKey(journey.userId)){
            users[journey.userId]?.add(journey.userId.toLong())
        } else {
            users.put(journey.userId, arrayListOf(journey.userId.toLong()))
        }
        journeys.put(journeyId, journey)
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