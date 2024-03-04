package com.otumian.springbootapiwithvalidation.validation

import org.springframework.stereotype.Service


interface IIdValidation {
    fun validate(id: Long)
}

@Service
class IdValidation (val mechanism: INumberValidationMechanism): IIdValidation {
    override fun validate(id: Long) {
        mechanism.idIsNumber(id, "id must be a number")
        mechanism.idIsLessThanOne(id, "id can not zero")
    }
}