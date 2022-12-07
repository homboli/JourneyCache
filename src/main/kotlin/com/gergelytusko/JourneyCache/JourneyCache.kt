package com.gergelytusko.JourneyCache

import com.gergelytusko.JourneyCache.model.Journey
import kotlin.random.Random


class JourneyCache {
    var journeys: HashMap<Long, Journey> = hashMapOf()
    var users: HashMap<Long, ArrayList<Long>> = hashMapOf()

    fun get(id: Long): Journey? {
        return journeys.get(id)
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