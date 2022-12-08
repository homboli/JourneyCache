package com.gergelytusko.JourneyCache.model

data class Journey(val id: Long,
                   val userId: Long,
                   val startLong: Double,
                   val startLat: Double,
                   val startTime: Long,
                   val endLong: Double,
                   val endLat: Double,
                   val endTime: Long,
                   val price: Double);
