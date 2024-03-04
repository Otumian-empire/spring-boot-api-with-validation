package com.otumian.springbootapiwithvalidation.controller

import com.otumian.springbootapiwithvalidation.dto.ArticleDto
import com.otumian.springbootapiwithvalidation.service.ArticleService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(val service: ArticleService) {

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
