package com.otumian.springbootapiwithvalidation.controller

import com.otumian.springbootapiwithvalidation.dto.ArticleDto
import com.otumian.springbootapiwithvalidation.service.ArticleService
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.springframework.format.annotation.NumberFormat
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(val service: ArticleService) {

    @GetMapping
    fun articles() = service.getArticles()

    @GetMapping("/{id}")
    fun article(@PathVariable id: Long) = service.getArticleById(id)

    @PostMapping
    fun newArticle(@Valid @RequestBody article: ArticleDto) = service.createArticle(article)

    @PutMapping("/{id}")
    fun updateArticle(
        @Valid
        @RequestBody article: ArticleDto,
        @Valid
        @PathVariable
        @NotNull(message = "Id required")
        @NumberFormat(style = NumberFormat.Style.NUMBER)
        @Positive(message = "Id must be a positive number")
        id: Long
    ): ArticleDto? {

        var a: ArticleDto? = null
        try {
         a=service.updateArticle(id, article)

        } catch (exception: Exception) {
            println(exception)
        }
        return  a
    }


    @DeleteMapping("/{id}")
    fun deleteArticle(
        @Valid
        @PathVariable
        @NotNull(message = "Id required")
        @Positive(message = "Id must be a positive number")
        id: Long
    ) = service.deleteArticleById(id)
}
