package com.gergelytusko.JourneyCache.controller

import com.gergelytusko.JourneyCache.cache
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class JourneyController {
    @GetMapping("/")
    fun getIndex() = "Hello world!"

    @GetMapping("/journey/{journey_id}")
    fun getJourney(@PathVariable journey_id: Long, @RequestHeader("api-user-id") apiUserId: Long) = cache.get(journey_id)

    @GetMapping("/user/{user_id}/journeys")
    fun getUserJourneys(@PathVariable user_id: Long, @RequestHeader("api-user-id") apiUserId: Long) = cache.getUserJourneys(user_id)
}