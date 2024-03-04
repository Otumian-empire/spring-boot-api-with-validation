package com.otumian.springbootapiwithvalidation.validation

import org.springframework.stereotype.Service


interface IArticleValidator {
    val article: ICreateArticleValidation
    val id: IIdValidation
}

@Service
class ArticleValidator(
    val articleValidation: ICreateArticleValidation,
    val idValidation: IIdValidation,
) : IArticleValidator {
    override val article: ICreateArticleValidation
        get() = articleValidation

    override val id: IIdValidation
        get() = idValidation

}
