package com.otumian.springbootapiwithvalidation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/v1/articles")
class ArticleController {
    val articles = mutableListOf(
        Article(
            "Hello world in Python",
            "A simple introduction to python programming, write hello world console application"
        )
    )

    @GetMapping
    fun articles() = articles

    @GetMapping("/{slug}")
    fun article(@PathVariable slug: String) =
        articles.find { article -> article.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        articles.add(article)
        return article
    }

    @PutMapping("/{slug}")
    fun updateArticle(@RequestBody article: Article, @PathVariable slug: String): Article {
        val existingArticle =
            articles.find { row -> row.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val index = articles.indexOf(existingArticle)
        existingArticle.content = article.content
        existingArticle.title = article.title

        articles[index] = existingArticle
        return article
    }

    @DeleteMapping("/{slug}")
    fun deleteArticle(@PathVariable slug: String) {
        articles.removeIf { row -> row.slug == slug }
    }
}