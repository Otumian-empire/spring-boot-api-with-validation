package com.otumian.springbootapiwithvalidation.validation

import com.otumian.springbootapiwithvalidation.handler.CustomException
import org.springframework.stereotype.Service


interface INumberValidationMechanism {
    fun idIsNumber(id: Any?, message: String)
    fun idIsLessThanOne(id: Any?, message: String)
}


@Service
class NumberValidationMechanism : INumberValidationMechanism {
    override fun idIsNumber(id: Any?, message: String) {
        if (id !is Long) {
            throw CustomException(message)
        }
    }

    override fun idIsLessThanOne(id: Any?, message: String) {
        if ((id as Long) < 1.toLong()) {
            throw CustomException(message)
        }
    }
}
