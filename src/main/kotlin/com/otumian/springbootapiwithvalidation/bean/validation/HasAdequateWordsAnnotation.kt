package com.otumian.springbootapiwithvalidation.bean.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Constraint(validatedBy = [HasAdequateWordsValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class HasAdequateWords(
    val message: String = "Must have minimum and maximum number of words",
    val groups: Array<KClass<*>> = [], // we won't be using this
    val payload: Array<KClass<out Payload>> = [], // we won't be using this
    val min: Int = 0,
    val max: Int = 120
)
