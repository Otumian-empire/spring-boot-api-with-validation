package com.otumian.springbootapiwithvalidation.validation

import com.otumian.springbootapiwithvalidation.dto.ArticleDto
import org.springframework.stereotype.Service


interface ICreateArticleValidation {
    fun validate(article: ArticleDto)
}

@Service
class CreateArticleValidation(val mechanism: IStringValidationMechanism): ICreateArticleValidation {
   override fun validate(article: ArticleDto) {
        this.titleValidation(article.title)
        this.contentValidation(article.content)
    }

    private fun titleValidation(title: String, minimum: Int = 3, maximum: Int = 10) {
        this.mechanism.isNotNull(title, "title is required")
        this.mechanism.isString(title, "title must be a string")
        this.mechanism.isAtLeast(
            value = title,
            minimum = minimum,
            message = "title must be at least $minimum words"
        )
        this.mechanism.isAtMost(
            value = title,
            maximum = maximum,
            message = "title must be at most $maximum words"
        )
    }

    private fun contentValidation(content: String, minimum: Int = 10, maximum: Int = 20) {
        this.mechanism.isNotNull(content, "content is required")
        this.mechanism.isString(content, "content must be a string")
        this.mechanism.isAtLeast(
            value = content,
            minimum = minimum,
            message = "content must be at least $minimum words"
        )
        this.mechanism.isAtMost(
            value = content,
            maximum = maximum,
            message = "content must be at most $maximum words"
        )
    }
}


