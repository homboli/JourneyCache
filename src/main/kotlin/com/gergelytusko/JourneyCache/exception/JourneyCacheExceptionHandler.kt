package com.gergelytusko.JourneyCache.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class JourneyCacheExceptionHandler {

    @ExceptionHandler
    fun handleIllegalStateException(exception: IllegalStateException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleUnauthorizedUserException(exception: UnauthorizedUserException): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.UNAUTHORIZED)
    }
}