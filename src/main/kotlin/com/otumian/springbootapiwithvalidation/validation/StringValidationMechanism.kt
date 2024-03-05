package com.otumian.springbootapiwithvalidation.validation

import com.otumian.springbootapiwithvalidation.handler.CustomException
import org.springframework.stereotype.Service


interface IStringValidationMechanism {
    fun isNotNull(value: Any?, message: String)
    fun isString(value: Any?, message: String)
    fun isAtLeast(value: Any?, minimum: Int, message: String)
    fun isAtMost(value: Any?, maximum: Int, message: String)
}


@Service
class StringValidationMechanism : IStringValidationMechanism {
    override fun isNotNull(value: Any?, message: String) {
        if (value == null) {
            throw CustomException(message)
        }
    }

    override fun isString(value: Any?, message: String) {
        if (value !is String) {
            throw CustomException(message)
        }
    }

    override fun isAtLeast(value: Any?, minimum: Int, message: String) {
        val newValue = value as String
        if (newValue.split(" ").count() < minimum) {
            throw CustomException(message)
        }
    }

    override fun isAtMost(value: Any?, maximum: Int, message: String) {
        val newValue = value as String
        if (newValue.split(" ").count() > maximum) {
            throw CustomException(message)
        }
    }
}
