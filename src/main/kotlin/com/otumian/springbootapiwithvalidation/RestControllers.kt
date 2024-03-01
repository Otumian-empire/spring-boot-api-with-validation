package com.otumian.springbootapiwithvalidation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


data class ApiError(val message: String, val status: HttpStatus=HttpStatus.BAD_REQUEST)
@RestControllerAdvice
@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(val service: ArticleService) {

    @ExceptionHandler(Exception::class)
    fun handleExceptions(exception: Exception): ResponseEntity<ApiError> {
        return ResponseEntity(exception.message?.let { ApiError(it) }, HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun articles() = service.getArticles()

    @GetMapping("/{id}")
    fun article(@PathVariable id: Long) = service.getArticleById(id)

    @PostMapping
    fun newArticle(@RequestBody article: ArticleDto) = service.createArticle(article)

    @PutMapping("/{id}")
    fun updateArticle(@RequestBody article: ArticleDto, @PathVariable id: Long) = service.updateArticle(id, article)

    @DeleteMapping("/{id}")
    fun deleteArticle(@PathVariable id: Long) = service.deleteArticleById(id)
}
