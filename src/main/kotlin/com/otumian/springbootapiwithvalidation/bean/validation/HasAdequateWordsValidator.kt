package com.otumian.springbootapiwithvalidation.bean.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


class HasAdequateWordsValidator(private var min: Int = 0, private var max: Int = 120) :
    ConstraintValidator<HasAdequateWords, String> {

    // Override the initialize method to set the min and max values from the annotation
    override fun initialize(hasMinimumWords: HasAdequateWords) {
        this.min = hasMinimumWords.min
        this.max = hasMinimumWords.max
    }

    override fun isValid(stringVal: String?, context: ConstraintValidatorContext): Boolean {
        // Check if the string is null or empty
        if (stringVal.isNullOrEmpty()) {
            return false
        }

        // Count the words in the string
        val size = stringVal.split(" ").count()

        // Check if the size is within the specified range
        return size in min..max
    }
}

