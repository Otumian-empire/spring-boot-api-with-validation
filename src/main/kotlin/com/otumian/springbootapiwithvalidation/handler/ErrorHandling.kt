package com.otumian.springbootapiwithvalidation.handler

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException


@RestControllerAdvice
class ErrorHandling {
    // handles any other error
    @ExceptionHandler(Exception::class)
    fun handleExceptions(exception: Exception): ResponseEntity<ApiError> {
        println("handleExceptions")
        println(exception)
        return ResponseEntity(
            ApiError(
                message = exception.message ?: "exception: Something went wrong",
                status = HttpStatus.INTERNAL_SERVER_ERROR
            ), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    // handles errors thrown by the validation middleware
    @ExceptionHandler(BindException::class)
    fun handleBeanValidationExceptions(exception: BindException): ResponseEntity<ApiError> {
        val message = exception.fieldErrors.associate { it.field to it.defaultMessage }
        val firstError = message.entries.firstOrNull()
        return ResponseEntity(ApiError(firstError?.value?:"Something went wrong with the validation"), HttpStatus.BAD_REQUEST)
    }

    // handles validation error (custom)
    @ExceptionHandler(CustomException::class)
    fun handleValidationExceptions(exception: CustomException): ResponseEntity<ApiError> {
        val message = exception.message
        return ResponseEntity(ApiError(message), HttpStatus.BAD_REQUEST)
    }

    // handles json parsing error
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<ApiError> {
        val message = "Invalid request body: ${exception.cause?.cause}"
        return ResponseEntity(ApiError(message), HttpStatus.BAD_REQUEST)
    }

    // handle sql error: DataIntegrityViolationException
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(exception: DataIntegrityViolationException): ResponseEntity<ApiError> {
        val message = "Some went wrong"
        return ResponseEntity(ApiError(message), HttpStatus.BAD_REQUEST)
    }

    // handle sql error: DataIntegrityViolationException
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(exception: MethodArgumentTypeMismatchException): ResponseEntity<ApiError> {
        val message = "Pass the appropriate value"
        return ResponseEntity(ApiError(message), HttpStatus.BAD_REQUEST)
    }
}