package com.gergelytusko.JourneyCache.controller

import com.gergelytusko.JourneyCache.exception.UnauthorizedUserException
import com.gergelytusko.JourneyCache.model.Journey
import com.gergelytusko.JourneyCache.service.JourneyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class JourneyController(val journeyService: JourneyService) {
    @GetMapping("/")
    fun getIndex() = "Hello world!"

    @GetMapping("/journey/{journey_id}")
    fun getJourney(@PathVariable journey_id: Long, @RequestHeader("api-user-id") apiUserId: Long): Journey {
        return journeyService.getJourney(apiUserId, journey_id)
    }

    @GetMapping("/user/{user_id}/journeys")
    fun getUserJourneys(@PathVariable user_id: Long, @RequestHeader("api-user-id") apiUserId: Long): ArrayList<Journey> {
        if(user_id.equals(apiUserId)){
            return journeyService.getJourneysByUserId(user_id)
        } else {
            throw UnauthorizedUserException("Unauthorized to access $user_id user's journeys")
        }
    }
}