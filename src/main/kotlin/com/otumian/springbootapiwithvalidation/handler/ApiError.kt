package com.otumian.springbootapiwithvalidation.handler

import org.springframework.http.HttpStatus

data class ApiError(val message: String, val status: HttpStatus = HttpStatus.BAD_REQUEST)
